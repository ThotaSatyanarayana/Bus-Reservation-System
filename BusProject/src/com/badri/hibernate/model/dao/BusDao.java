package com.badri.hibernate.model.dao;

import java.util.List;

import com.badri.hibernate.model.Bus;
import com.badri.hibernate.model.Route;

public interface BusDao {
	public List<Bus> findByRouteAndDate(Route route,String date);
	public Bus searchbus(int id);
}
