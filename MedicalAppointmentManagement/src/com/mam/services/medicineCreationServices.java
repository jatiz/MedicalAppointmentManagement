package com.mam.services;

import com.mam.bean.medicineObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;
import com.mam.dao.databaseValidation;
import com.mam.dao.medicineCreation;
import com.mam.dao.retrieveID;
import com.mam.keygenerator.keyGenerator;
import com.mam.validation.medicineValidate;

public class medicineCreationServices {

	private medicineObj medObj = new medicineObj();
	private keyGenerator generateID = new keyGenerator();
	private retrieveID requestID = new retrieveID();
	private medicineValidate medValid = new medicineValidate();
	private medicineCreation medCreate = new medicineCreation();
	private databaseValidation dbValid = new databaseValidation();
	
	public boolean medicineCreate(String medicineName, String medicineDesc, String patientName, String appointmentName, String remark, int quantity) throws mamException, mamThrowableException{
		medObj.setMedicineID(Integer.toString(generateID.randomizeAccID()));
		medObj.setMedicineName(medicineName);
		medObj.setMedicineDesc(medicineDesc);
		medObj.setPatientID(requestID.retrivePatientID(patientName));
		medObj.setAppointmentID(requestID.retriveAppointmentID(appointmentName));
		medObj.setRemark(remark);
		medObj.setQuantity(quantity);
		
		if(medValid.validateName(medObj)){
			if(medValid.validateQuantity(medObj)){
				if(!dbValid.checkMedicineRecord(medObj)){
					medCreate.medicineCreate(medObj);
					return true;
				}else{
					return false;
				}
			}
		}
		
		return false;
	}
	
	public boolean medicineCreateWithoutAppointment(String medicineName, String medicineDesc, String patientName, String remark, int quantity) throws mamException, mamThrowableException{
		medObj.setMedicineID(Integer.toString(generateID.randomizeAccID()));
		medObj.setMedicineName(medicineName);
		medObj.setMedicineDesc(medicineDesc);
		medObj.setPatientID(requestID.retrivePatientID(patientName));
		medObj.setRemark(remark);
		medObj.setQuantity(quantity);
		
		if(medValid.validateName(medObj)){
			if(medValid.validateQuantity(medObj)){
				if(!dbValid.checkMedicineRecordWithoutAppointmentID(medObj)){
					medCreate.medicineCreateWithoutAppointment(medObj);
					return true;
				}else{
					return false;
				}
			}
		}
		
		return false;
	}
}
