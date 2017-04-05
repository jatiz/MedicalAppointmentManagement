package com.mam.validation;

import com.mam.bean.medicineObj;
import com.mam.customexception.mamException;

public class medicineValidate {

	private medicineObj newMed;
	private String alphaPattern = "[a-zA-Z ]*$";
	//private String alphaPattern = "[a-zA-Z]+";
	
	public boolean validateName(medicineObj medObj) throws mamException {
		newMed = medObj;
		
		if (newMed.getMedicineName().matches(alphaPattern)) {
			System.out.println("return true :valideteAppointmentName");
			return true;
		} else {
			//System.out.println("FirstName validation error");
			throw new mamException("AppointmentName validation error");
		}
	}
	
	public boolean validateQuantity(medicineObj medObj) throws mamException{
		newMed = medObj;
		
		
		if(newMed.getQuantity()>0){
			return true;
		}else{
			throw new mamException("Medicine quantity cannot be negative number");
		}
	}
}
