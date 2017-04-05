package com.mam.validation;

import com.mam.bean.appointmentObj;
import com.mam.customexception.mamException;

public class appointmentValidate {

	private appointmentObj newAppt;
	private String alphaPattern = "[a-zA-Z ]*$";
	//private String alphaPattern = "[a-zA-Z]+";
	
	public boolean validateName(appointmentObj apptObj) throws mamException {
		newAppt = apptObj;
		
		if (newAppt.getAppointmentName().matches(alphaPattern)) {
			System.out.println("return true :valideteAppointmentName");
			return true;
		} else {
			//System.out.println("FirstName validation error");
			throw new mamException("AppointmentName validation error");
		}
	}
}
