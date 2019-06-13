package com.badri.hibernate.model.dao;

import java.util.List;

import com.badri.hibernate.model.Route;

public interface RouteDao {
	public List<String> getRoutes();

	public List<Route> getDestinationByOrigin(String origin);
	
	public Route getRoute(int id);

}
