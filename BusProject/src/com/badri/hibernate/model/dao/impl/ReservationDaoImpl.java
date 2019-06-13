package com.badri.hibernate.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.badri.bean.Reservation;
import com.badri.hibernate.model.dao.ReservationDao;

@Repository
public class ReservationDaoImpl implements ReservationDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Reservation> findByPid(int passengerID) {

		String query = "select * from reservation where passenger_id = ?";

		List<Reservation> reservationBeans = jdbcTemplate.query(query, new Object[] { passengerID },
				new BeanPropertyRowMapper<Reservation>(Reservation.class));
		return reservationBeans;
	}

}
