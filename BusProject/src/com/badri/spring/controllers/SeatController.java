package com.badri.spring.controllers;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.badri.bean.Reservation;
import com.badri.hibernate.model.Reserve;
import com.badri.service.BusService;
import com.badri.service.ReserveService;
import com.badri.service.RouteService;
import com.badri.util.DateUtil;
import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;

@Controller
public class SeatController {
	@Autowired
	ReserveService reserveService; 
	@Autowired
	BusService busService;
	@Autowired
	RouteService routeService;
	List<Reservation> tickets = new ArrayList<Reservation>();

	@RequestMapping(value = "/saveseat", method = RequestMethod.POST)
	public ModelAndView saveSeat(HttpServletRequest request)
			throws ParseException, FileNotFoundException, DocumentException {
		ModelAndView modelandview = new ModelAndView("bus/Seat");
		String[] seatsdata = request.getParameterValues("seat");
		modelandview.addObject("seats", new Reserve());
		if (seatsdata != null) {
			for (String seat : seatsdata) {
				reserveSeat(request, Integer.parseInt(seat));
			}
			modelandview.addObject("seatmessage", "seat is booked");
			return modelandview;
		} else {
			modelandview.addObject("seatmessage", "please select seat");
			return modelandview;
		}
	}

	@RequestMapping(value = "/seats/{bus_id}")
	public ModelAndView getSeats(@PathVariable int bus_id, HttpServletRequest request) {
		ModelAndView modelandview = new ModelAndView("bus/Seat");
		HttpSession session = request.getSession();
		session.setAttribute("busid", bus_id);
		modelandview.addObject("seats", new Reserve());
		modelandview.addObject("seatslist", getSeatsList());
		return modelandview;
	}

	@ModelAttribute("seatslist")
	public List<String> getSeatsList() {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 40; i++) {
			list.add(String.format("%02d", i));
		}
		return list;
	}

	@RequestMapping(value = "/avilableseats")
	public @ResponseBody String getAvialableseats(HttpServletRequest request) {
		Gson json = new Gson();
		HttpSession session = request.getSession(false);
		String date = (String) session.getAttribute("date");
		int id = (Integer) session.getAttribute("busid");
		List<Integer> avilableseats = reserveService.getSeatNumbersByBusAndDate(id, date);
		List<String> remainingseats = new ArrayList<String>();
		for (int i : avilableseats) {
			remainingseats.add(String.format("%02d", i));
		}
		String seats = "";
		if (!remainingseats.isEmpty()) {
			seats = json.toJson(remainingseats);
		}
		return seats;

	}

	private void reserveSeat(HttpServletRequest request, int seatnumber) throws ParseException {
		HttpSession session = request.getSession(false);
		int id = (Integer) session.getAttribute("id");
		String date = (String) session.getAttribute("date");
		int busid = (Integer) session.getAttribute("busid");
		Reserve reserve = new Reserve();
		reserve.setPassenger_id(id);
		reserve.setBus_id(busid);
		reserve.setDt(date);
		reserve.setTstamp(DateUtil.getTimeStamp());
		reserve.setSeat(seatnumber);
		int ticketno = reserveService.reserve(reserve);
		reserve.setReserve_id(ticketno);
		Reservation reservation = new Reservation(reserve);
		tickets.add(reservation);
	}
}
