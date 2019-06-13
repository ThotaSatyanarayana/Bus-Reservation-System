package com.badri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badri.hibernate.model.Bus;
import com.badri.hibernate.model.Route;
import com.badri.hibernate.model.dao.BusDao;
import com.badri.service.BusService;

@Service
public class BusServiceImpl implements BusService {
	@Autowired
	BusDao busDao;

	public List<Bus> findByRouteAndDate(Route route, String date) {
		return busDao.findByRouteAndDate(route, date);
	}

	public Bus searchbus(int id) {
		return busDao.searchbus(id);
	}


}
