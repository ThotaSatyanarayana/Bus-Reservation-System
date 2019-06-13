package com.badri.spring.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.badri.hibernate.model.Route;

@Component
public class RouteValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Route.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors error) {
		Route route = (Route) target;
		if (route.getOrigin().equalsIgnoreCase("Select Source")) {
			error.rejectValue("origin", "route.origin.empty");
		}
		if (route.getDestination().equalsIgnoreCase("Select Destination")) {
			error.rejectValue("destination", "route.destination.empty");
		}
		if (route.getMonth().equalsIgnoreCase("Select Month")) {
			error.rejectValue("month", "route.month.empty");
		}
	}

}
