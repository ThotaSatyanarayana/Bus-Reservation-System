package com.badri.hibernate.model.dao;

import java.util.List;

import com.badri.bean.Reservation;

public interface ReservationDao {
	public List<Reservation> findByPid(int passengerID);
}
