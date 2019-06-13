package com.badri.service;


import com.badri.hibernate.model.Passenger;

public interface PassengerService {
	public void savePassenger(Passenger passenger);

	public Passenger validateLogin(Passenger passenger);
}
