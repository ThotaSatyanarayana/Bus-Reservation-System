package com.badri.hibernate.model.dao;


import com.badri.hibernate.model.Passenger;

public interface PassengerDao {
	public void savePassenger(Passenger passenger);

	public Passenger validateLogin(Passenger passenger);
	
}
