package com.mam.main;

import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;
import com.mam.services.addPatientServices;

public class servletSimulationAddPatient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		addPatientServices addPatient = new addPatientServices();
		try {
			if(addPatient.createPatient("napihup@gmail.com", "john", "Mayer", "29", "02", "19973")){
				System.out.println("Patient Account Successfully Created");
			}else{
				System.out.println("Patient Account unable to create");
			}
		} catch (mamException e) {
			// TODO Auto-generated catch block
			System.out.println("mamException ERROR: " +e.getMessage());
		} catch (mamThrowableException e) {
			// TODO Auto-generated catch block
			System.out.println("mamThrowableException:" + e.getCause());
		}
	}

}
