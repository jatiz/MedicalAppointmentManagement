package com.mam.services;

import com.mam.bean.appointmentObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;
import com.mam.dao.appointmentCreation;
import com.mam.dao.databaseValidation;
import com.mam.dao.retrieveUserID;
import com.mam.keygenerator.keyGenerator;
import com.mam.validation.appointmentValidate;
import com.mam.validation.dateTimeValidate;

public class appointmentCreationServices {

	private appointmentObj apptObj = new appointmentObj();
	private keyGenerator generateID = new keyGenerator();
	private retrieveUserID requestPatientID = new retrieveUserID();
	private dateTimeValidate dtValidate = new dateTimeValidate();
	private appointmentValidate apptValidate = new appointmentValidate();
	private databaseValidation dbValidate = new databaseValidation();
	private appointmentCreation apptCreate = new appointmentCreation();
	
	public boolean appointmentCreate(String appointmentName, String name, String year, String month, String date, String time, String venue, String appointmentDesc) throws mamException, mamThrowableException{
		apptObj.setAppointmentID(Integer.toString(generateID.randomizeAccID()));
		apptObj.setAppointmentName(appointmentName);
		apptObj.setPatientID(requestPatientID.retrivePatientID(name));
		apptObj.setDate(year + "-" + month + "-" + date);
		if(dtValidate.validateTime(time)){									//Assigning appointment object.
			apptObj.setTime(dtValidate.convertTimeFormat(time));
		}else{
			throw new mamException("Invalid Time-Format");
		}
		apptObj.setVenue(venue);
		apptObj.setAppointmentDesc(appointmentDesc);
		
		if(apptValidate.validateName(apptObj)){		//check for proper naming on each field.
			if(dtValidate.validateDate(apptObj.getDate())){
				if(!dbValidate.checkAppointmentRecord(apptObj)){	//check for duplicate on database.
					apptCreate.createAppointment(apptObj);		//call database for insertion.
					return true;
				}
			}
			
		}
		
		return false;
	}
	
}
