package com.mam.services;

import com.mam.bean.auditorObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;
import com.mam.dao.auditorCreation;
import com.mam.dao.databaseValidation;
import com.mam.dao.retrieveID;
import com.mam.keygenerator.keyGenerator;
import com.mam.validation.auditorValidate;

public class auditorCreationServices {
	
	private auditorObj auditObj = new auditorObj();
	private keyGenerator generateID = new keyGenerator();
	private retrieveID requestID = new retrieveID();
	private auditorValidate auditValid = new auditorValidate();
	private databaseValidation dbValid = new databaseValidation();
	private auditorCreation auditCreate = new auditorCreation();
	
	public boolean createAuditor(String auditorGrpName, String email, String patientName) throws mamException, mamThrowableException{
		auditObj.setAuditID(Integer.toString(generateID.randomizeAccID()));
		auditObj.setAuditorGrpName(auditorGrpName);
		auditObj.setAccID(requestID.retrieveUserID(email));
		if(dbValid.checkPatientLinkToUser(patientName, auditObj.getAccID())){
			auditObj.setPatientID(requestID.retrivePatientID(patientName));
			auditObj.setGroupAdmin("YES");
		}else{
			throw new mamException("No patient associated with this user");
		}
		
		
		if(auditValid.validateGrpName(auditObj)){
			if(!dbValid.checkAuditorGrpName(auditObj)){
				auditCreate.auditCreate(auditObj);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean addAuditor(String adminEmail, String email, String auditorGrpName, String patientName) throws mamException, mamThrowableException{
		auditObj.setAccID(requestID.retrieveUserID(email));
		auditObj.setAuditorGrpName(auditorGrpName);
		auditObj.setPatientID(requestID.retrivePatientID(patientName));
		auditObj.setAuditID(dbValid.getAuditID(auditObj, adminEmail));
		
		if(auditValid.validateGrpName(auditObj)){
			if(!dbValid.checkAddedUser(auditObj)){
				auditCreate.auditAdd(auditObj);
				return true;
			}
			
		}
		
		
		return false;
	}

}
