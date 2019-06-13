package com.badri.service;

import java.util.List;

import com.badri.bean.Reservation;

public interface ReservationService {
	public List<Reservation> findByPid(int passengerID);
}
