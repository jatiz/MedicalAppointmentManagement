package com.mam.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mam.bean.patientObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;

public class patientValidate {

	private patientObj newPatient;
	private String alphaPattern = "[a-zA-Z]+";

	public boolean validateAll(patientObj patient) throws mamException, mamThrowableException {
		newPatient = patient;
		if (validateName()) {
			if (validateDOB()) {
				return true;
			}
		}

		return false;
	}

	public boolean validateName() throws mamException {

		if (newPatient.getFirstName().matches(alphaPattern)) {
			System.out.println("return true :valideteFirstName");
			if (newPatient.getLastName().matches(alphaPattern)) {
				System.out.println("return true :validateLastName");
				return true;
			} else {
				//System.out.println("LastName validation error");
				throw new mamException("LastName validation error");
			}
		} else {
			//System.out.println("FirstName validation error");
			throw new mamException("FirstName validation error");
		}
	}

	public boolean validateDOB() throws mamException, mamThrowableException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(newPatient.getDOB().trim());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new mamThrowableException("Invalid date", e);
		}
		return true;
	}
	
}
