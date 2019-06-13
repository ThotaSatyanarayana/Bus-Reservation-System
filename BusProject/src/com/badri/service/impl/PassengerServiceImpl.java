package com.badri.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badri.hibernate.model.Passenger;
import com.badri.hibernate.model.dao.PassengerDao;
import com.badri.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	PassengerDao passengerDao;

	public void savePassenger(Passenger passenger) {
		passengerDao.savePassenger(passenger);
	}

	public Passenger validateLogin(Passenger passenger) {
		return passengerDao.validateLogin(passenger);
	}

}
