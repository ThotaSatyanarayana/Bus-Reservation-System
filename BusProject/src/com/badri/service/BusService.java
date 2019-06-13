package com.badri.service;

import java.util.List;

import com.badri.hibernate.model.Bus;
import com.badri.hibernate.model.Route;

public interface BusService {
	public List<Bus> findByRouteAndDate(Route route, String date);
	
	public Bus searchbus(int id);
	
}
