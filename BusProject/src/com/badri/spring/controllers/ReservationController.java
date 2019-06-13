package com.badri.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.badri.bean.Reservation;
import com.badri.hibernate.model.Reserve;
import com.badri.service.ReservationService;
import com.badri.service.ReserveService;

@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	@Autowired
	ReserveService reserveService;

	@RequestMapping("/CancelTicket")
	public ModelAndView showCancelTicket() {
		return new ModelAndView("bus/CancelTicket", "ticket", new Reserve());
	}

	@RequestMapping(value = "/cancelticket", method = RequestMethod.POST)
	public ModelAndView cancelTicket(@ModelAttribute("ticket") Reserve reserve, BindingResult result,
			HttpServletRequest request) {
		ModelAndView modelandview = new ModelAndView("bus/CancelTicket");
		ModelAndView modelandviewlogin = new ModelAndView("redirect:Login");
		boolean error = false;
		if (reserve.getReserve_id() == 0) {
			result.rejectValue("reserve_id", "reserve.ticket.empty");
			error = true;
		}
		if (error) {
			return modelandview;
		}

		Reserve reservedata = reserveService.findById(reserve.getReserve_id());
		HttpSession session = request.getSession(false);

		try {
			int id = (Integer) session.getAttribute("id");
			if (reservedata != null) {
				if (reservedata.getPassenger_id() == id) {
					reserveService.cancelTicketByid(reserve.getReserve_id());
					modelandview.addObject("ticketmessage", "Ticket Canceled");
				} else {
					modelandview.addObject("ticketmessage", "ticket number is invalid");
				}
			} else {
				modelandview.addObject("ticketmessage", "enter valid ticket number");
			}
			return modelandview;
		}

		catch (Exception e) {
			return modelandviewlogin;
		}
	}

	@RequestMapping("/reservationhistory")
	public ModelAndView reservationHistory(HttpServletRequest request) {
		ModelAndView modelandview = new ModelAndView("bus/History");
		ModelAndView modelandviewlogin = new ModelAndView("redirect:Login");
		HttpSession session = request.getSession(false);
		try {
			int id = (Integer) session.getAttribute("id");
			List<Reservation> reservationhistory = reservationService.findByPid(id);
			modelandview.addObject("history", reservationhistory);
			return modelandview;
		} catch (Exception e) {
			return modelandviewlogin;
		}
	}
}
