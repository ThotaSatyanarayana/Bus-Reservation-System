package com.badri.service;

import java.util.List;

import com.badri.hibernate.model.Reserve;

public interface ReserveService {
	public List<Integer> getSeatNumbersByBusAndDate(int busid, String date);

	public int reserve(Reserve reserve);

	public Reserve findById(int id);

	public void cancelTicketByid(int id);
}
