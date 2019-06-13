package com.badri.service;

import java.util.List;

import com.badri.hibernate.model.Route;

public interface RouteService {
	public List<String> getRoutes();

	public List<Route> getDestinationByOrigin(String origin);

	public Route getRoute(int id);
}
