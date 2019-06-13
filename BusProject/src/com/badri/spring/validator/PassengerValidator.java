package com.badri.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.badri.hibernate.model.Passenger;

@Component
public class PassengerValidator implements Validator {
	public static final String PNG_MIME_TYPE = "image/png";
	public static final String JPG_MIME_TYPE = "image/jpeg";
	public static final long ONE_MB_IN_BYTES = 1000000;

	public boolean supports(Class<?> clazz) {
		return Passenger.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors error) {
		Passenger passenger = (Passenger) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "name", "passenger.name.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "email", "passenger.email.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "passenger.password.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "confirmpassword", "passenger.confirmpassword.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "mobile", "passenger.mobile.empty");

		if (passenger.getPhotoname().isEmpty()) {
			error.rejectValue("photo", "passenger.photo.empty");
		}
		if (!passenger.getEmail().isEmpty() && !passenger.getEmail().matches("^(.+)@(.+)$")) {
			error.rejectValue("email", "passenger.email.mismatch");
		}
		if (!passenger.getName().isEmpty() && !passenger.getName().matches("[A-Za-z ]*")) {
			error.rejectValue("name", "passenger.name.mismatch");
		}
		if (!passenger.getMobile().isEmpty() && !passenger.getMobile().matches("[0-9]{10}")) {
			error.rejectValue("mobile", "passenger.mobile.mismatch");
		}
		if (!passenger.getPhotoname().isEmpty()) {
			if (!PNG_MIME_TYPE.equalsIgnoreCase(passenger.getPhototype())
					&& !JPG_MIME_TYPE.equalsIgnoreCase(passenger.getPhototype())) {
				error.rejectValue("photo", "passenger.type.mismatch");
			}
		}
		if (!passenger.getPhotoname().isEmpty()) {
			if (passenger.getPhotosize() > ONE_MB_IN_BYTES) {
				error.rejectValue("photo", "passnger.size.mismatch");
			}
		}
		if (!passenger.getPassword().isEmpty() && !passenger.getConfirmpassword().isEmpty()) {
			if (!passenger.getPassword().equals(passenger.getConfirmpassword())) {
				error.rejectValue("password", "passnger.password.mismatch");
			}
		}

	}

}
