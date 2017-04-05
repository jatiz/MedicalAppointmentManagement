package com.mam.services;

import com.mam.bean.patientObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;
import com.mam.dao.databaseValidation;
import com.mam.dao.insertPatient;
import com.mam.dao.retrieveID;
import com.mam.keygenerator.keyGenerator;
import com.mam.validation.patientValidate;

public class addPatientServices {

	private patientObj patient = new patientObj();
	private patientValidate patientValidate = new patientValidate();
	private keyGenerator generateID = new keyGenerator();
	
	private databaseValidation dbValidate = new databaseValidation();
	private insertPatient insertPatient = new insertPatient();
	private retrieveID requestCareGiver = new retrieveID();

	public boolean createPatient(String email,String firstName, String lastName, String date, String month, String year) throws mamException, mamThrowableException {
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setDOB(year + "-" + month + "-" + date);
		patient.setPatientID(Integer.toString(generateID.randomizeAccID()));

		if(patientValidate.validateAll(patient)){
			if(!dbValidate.checkPatientAccount(patient)){
				patient.setCareGiver(requestCareGiver.retrieveUserID(email));
				insertPatient.addPatient(patient);
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
}
