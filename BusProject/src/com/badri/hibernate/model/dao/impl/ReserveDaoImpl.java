package com.badri.hibernate.model.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.badri.hibernate.model.Reserve;
import com.badri.hibernate.model.dao.ReserveDao;

@Repository
public class ReserveDaoImpl implements ReserveDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Integer> getSeatNumbersByBusAndDate(int busid, String date) {
		Session session = sessionFactory.openSession();
		String hql = "select s.seat from Reserve s where s.bus_id=:busid and s.dt=STR_TO_DATE(:dt,'%e-%M-%Y')";
		Query query = session.createQuery(hql);
		query.setParameter("busid", busid);
		query.setParameter("dt", date);
		List<Integer> seats = query.list();
		return seats;
	}

	public int reserve(Reserve reserve) {
		Session session = sessionFactory.openSession();
		String hql = "insert into reserve(passenger_id,bus_id,dt,tstamp,seat)values(:passengerid,:busid,STR_TO_DATE(:dt,'%e-%M-%Y'),STR_TO_DATE(:tstamp,'%e/%b/%Y'),:seat)";
		SQLQuery query = session.createSQLQuery(hql);
		query.setParameter("passengerid", reserve.getPassenger_id());
		query.setParameter("busid", reserve.getBus_id());
		query.setParameter("dt", reserve.getDt());
		query.setParameter("tstamp", reserve.getTstamp());
		query.setParameter("seat", reserve.getSeat());
		query.executeUpdate();
		int id = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();
		return id;
	}

	public Reserve findById(int id) {
		Session session = sessionFactory.openSession();
		Reserve reserve = (Reserve) session.get(Reserve.class, id);
		return reserve;
	}

	public void cancelTicketByid(int id) {
		Session session = sessionFactory.openSession();
		Reserve reserve = (Reserve) session.get(Reserve.class, id);
		session.beginTransaction();
		session.delete(reserve);
		session.beginTransaction().commit();
	}

}
