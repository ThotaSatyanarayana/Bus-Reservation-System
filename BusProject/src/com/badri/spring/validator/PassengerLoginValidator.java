package com.badri.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.badri.hibernate.model.Passenger;

@Component
public class PassengerLoginValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Passenger.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors error) {
		Passenger passenger = (Passenger) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "email", "passenger.email.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "passenger.password.empty");
		if (!passenger.getEmail().isEmpty() && !passenger.getEmail().matches("^(.+)@(.+)$")) {
			error.rejectValue("email", "passenger.email.mismatch");
		}
	}

}
