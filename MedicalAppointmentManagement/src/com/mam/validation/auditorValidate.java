package com.mam.validation;

import com.mam.bean.auditorObj;
import com.mam.customexception.mamException;

public class auditorValidate {

	private auditorObj newAudit;
	private String alphaPattern = "[a-zA-Z ]*$";
	//private String alphaPattern = "[a-zA-Z]+";
	
	public boolean validateGrpName(auditorObj auditObj) throws mamException {
		newAudit = auditObj;
		
		if (newAudit.getAuditorGrpName().matches(alphaPattern)) {
			System.out.println("return true :validete AuditorGrpName");
			return true;
		} else {
			//System.out.println("FirstName validation error");
			throw new mamException("AuditorGrpName validation error");
		}
	}
}
