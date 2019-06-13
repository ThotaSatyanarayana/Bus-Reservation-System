package com.badri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badri.hibernate.model.Route;
import com.badri.hibernate.model.dao.RouteDao;
import com.badri.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {
	@Autowired
	RouteDao routeDao;

	public List<String> getRoutes() {
		return routeDao.getRoutes();
	}

	public List<Route> getDestinationByOrigin(String origin) {
		return routeDao.getDestinationByOrigin(origin);
	}

	public Route getRoute(int id) {
		return routeDao.getRoute(id);
	}

}
