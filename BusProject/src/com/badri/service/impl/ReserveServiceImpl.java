package com.badri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badri.hibernate.model.Reserve;
import com.badri.hibernate.model.dao.ReserveDao;
import com.badri.service.ReserveService;

@Service
public class ReserveServiceImpl implements ReserveService{
	@Autowired
	ReserveDao reserveDao;

	public List<Integer> getSeatNumbersByBusAndDate(int busid, String date) {
		return reserveDao.getSeatNumbersByBusAndDate(busid, date);
	}

	public int reserve(Reserve reserve) {
		return reserveDao.reserve(reserve);
	}

	public Reserve findById(int id) {
		return reserveDao.findById(id);
	}

	public void cancelTicketByid(int id) {
		reserveDao.cancelTicketByid(id);
	}
}
