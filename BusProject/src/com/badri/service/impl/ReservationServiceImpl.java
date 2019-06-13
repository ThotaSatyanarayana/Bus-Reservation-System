package com.badri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badri.bean.Reservation;
import com.badri.hibernate.model.dao.ReservationDao;
import com.badri.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	ReservationDao reservationDao;

	public List<Reservation> findByPid(int passengerID) {
		return reservationDao.findByPid(passengerID);
	}

}
