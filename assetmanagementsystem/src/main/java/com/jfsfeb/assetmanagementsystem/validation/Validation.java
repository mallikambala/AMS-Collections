package com.jfsfeb.assetmanagementsystem.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfsfeb.assetmanagementsystem.exception.AMSException;

public class Validation {
	public boolean validatedId(int id) throws AMSException {
		String idRegEx = "[0-9]{1}[0-9]{2}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new AMSException("Please enter 3 digits");
		}
		return result;
	}

	public boolean validatedName(String name) throws AMSException {
		String nameRegEx = "^(?=.{4,20}$)(?![_.-])(?!.*[.]{2})[a-zA-Z._-]+(?<![_.-])";
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AMSException("Name should have atleast 4 characters and no numbers are allowed");
		}
		return result;
	}

	public boolean validatedEmail(String email) throws AMSException {
		String emailRegEx = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\" + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
		boolean result = false;
		Pattern pattern = Pattern.compile(emailRegEx);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AMSException("Email should have '@gmail.com'");
		}
		return result;
	}

	public boolean validatedPassword(String password) throws AMSException {
		String passwordRegEx = "((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%]).{6,20})";
		boolean result = false;
		if (Pattern.matches(passwordRegEx, String.valueOf(password))) {
			result = true;
		} else {
			throw new AMSException(
					"Password should contain atleast 6 characters ,one uppercase,one lowercase,one number,one special symbol(@#$%) ");
		}
		return result;
	}
}
