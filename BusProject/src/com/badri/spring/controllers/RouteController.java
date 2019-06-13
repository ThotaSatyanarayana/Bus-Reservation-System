package com.badri.spring.controllers;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.badri.hibernate.model.Bus;
import com.badri.hibernate.model.Route;
import com.badri.service.BusService;
import com.badri.service.RouteService;
import com.badri.spring.validator.RouteValidator;
import com.badri.util.DateUtil;
import com.google.gson.Gson;

@Controller
public class RouteController {
	@Autowired
	RouteService routeService;
	@Autowired
	RouteValidator routeValidator;
	@Autowired
	BusService busService;

	@RequestMapping(value = "/destinations")
	public @ResponseBody String getDestinations(@RequestParam("origin") String origin) {
		Gson json = new Gson();
		return json.toJson(routeService.getDestinationByOrigin(origin));
	}

	@RequestMapping(value = "/dates")
	public @ResponseBody String getDates(@RequestParam("month") String monthname, @RequestParam("year") int year) {
		Gson json = new Gson();
		int month = Month.valueOf(monthname.toUpperCase()).getValue();
		int maxDaysOfAMonth = DateUtil.maxDaysOfAMonth(year, month);
		List<Integer> dates = new ArrayList<Integer>();
		for (int i = 1; i <= maxDaysOfAMonth; i++) {
			dates.add(i);
		}
		String date = json.toJson(dates);
		return date;
	}

	@RequestMapping(value = "/searchbus", method = RequestMethod.POST)
	public ModelAndView searchBuses(@ModelAttribute("route") Route route, BindingResult result,
			HttpServletRequest request) {
		ModelAndView modelandview = new ModelAndView("bus/Route");
		ModelAndView busmodelandview = new ModelAndView("bus/Buses");
		routeValidator.validate(route, result);
		if (result.hasErrors()) {
			populateData(modelandview);
			return modelandview;
		}
		int monthnumber = Month.valueOf(route.getMonth().toUpperCase()).getValue();
		String date = route.getDay() + "-" + route.getMonth() + "-" + route.getYear();
		HttpSession session = request.getSession();
		session.setAttribute("date", date);
		if (monthnumber > DateUtil.currentMonth() || route.getYear() > DateUtil.currentYear()
				|| monthnumber == DateUtil.currentMonth() && route.getDay() >= DateUtil.currentDay()) {
			List<Bus> buses = busService.findByRouteAndDate(route, date);
			busmodelandview.addObject("buses", buses);
			busmodelandview.addObject("origin", route.getOrigin());
			busmodelandview.addObject("destination", route.getDestination());
		} else {
			populateData(modelandview);
			modelandview.addObject("datemessage", "please select feature date");
			return modelandview;
		}
		return busmodelandview;
	}

	@RequestMapping("/Route")
	public ModelAndView showRoute() {
		ModelAndView modelandview = new ModelAndView("bus/Route");
		modelandview.addObject("route", new Route());
		List<String> routes = routeService.getRoutes();
		modelandview.addObject("routes", routes);
		modelandview.addObject("monthnames", DateUtil.getMonthNames());
		modelandview.addObject("years", DateUtil.getYears());
		return modelandview;
	}

	public void populateData(ModelAndView modelandview) {
		List<String> routes = routeService.getRoutes();
		modelandview.addObject("routes", routes);
		modelandview.addObject("monthnames", DateUtil.getMonthNames());
		modelandview.addObject("years", DateUtil.getYears());
	}

}
