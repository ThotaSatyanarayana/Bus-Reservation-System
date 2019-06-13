package com.badri.spring.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.badri.exception.DatabaseException;
import com.badri.hibernate.model.Passenger;
import com.badri.service.PassengerService;
import com.badri.service.RouteService;
import com.badri.spring.validator.PassengerLoginValidator;
import com.badri.spring.validator.PassengerValidator;

@Controller
public class PassengerController {
	@Autowired
	PassengerValidator passengerValidator;
	@Autowired
	PassengerService passengerService;
	@Autowired
	PassengerLoginValidator passengerLoginValidator;
	@Autowired
	RouteService routeService;

	@RequestMapping("/Register")
	public ModelAndView showRegister() {
		ModelAndView modelandview = new ModelAndView("passenger/Register");
		modelandview.addObject("passenger", new Passenger());
		return modelandview;
	}

	@RequestMapping("/Logout")
	public ModelAndView showLogout() {
		ModelAndView modelandview = new ModelAndView("passenger/Logout");
		return modelandview;
	}

	@RequestMapping("/Login")
	public ModelAndView showLogin() {
		ModelAndView modelandview = new ModelAndView("passenger/Login");
		modelandview.addObject("passenger", new Passenger());
		return modelandview;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ExceptionHandler(DatabaseException.class)
	public ModelAndView savePassenger(@ModelAttribute("passenger") Passenger passenger, BindingResult result,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
		ModelAndView modelandview = new ModelAndView("passenger/Register");
		passenger.setPhotoname(file.getOriginalFilename());
		passenger.setPhototype(file.getContentType());
		passenger.setPhoto(file.getBytes());
		passenger.setPhotosize(file.getSize());
		passengerValidator.validate(passenger, result);
		if (result.hasErrors()) {
			return modelandview;
		}
		try {
			passengerService.savePassenger(passenger);
			modelandview.addObject("success", "Registered SuccessFully");
			return modelandview;
		} catch (Exception e) {
			throw new DatabaseException("email is already registered");
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginValidate(@ModelAttribute("passenger") Passenger passenger, BindingResult result,
			HttpServletRequest request) {
		ModelAndView modelandview = new ModelAndView("passenger/Login");
		ModelAndView routemodelandview = new ModelAndView("redirect:Route");
		passengerLoginValidator.validate(passenger, result);
		if (result.hasErrors()) {
			return modelandview;
		}
		Passenger passengerdata = passengerService.validateLogin(passenger);
		if (passengerdata != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", passengerdata.getPassenger_id());
			session.setMaxInactiveInterval(30);
			return routemodelandview;
		} else {
			modelandview.addObject("fail", "email or password is incorrect");
			return modelandview;
		}
	}
}
