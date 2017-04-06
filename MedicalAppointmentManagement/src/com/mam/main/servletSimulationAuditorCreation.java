package com.mam.main;

import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;
import com.mam.services.auditorCreationServices;

public class servletSimulationAuditorCreation {

	public static void main(String[] args) {
		auditorCreationServices auditCreateServices = new auditorCreationServices();
		
		try {
			//if(auditCreateServices.createAuditor("tester", "anonymousjatiz@gmail.com", "napi"))
			if(auditCreateServices.addAuditor("anonymousjatiz@gmail.com", "napihup@gmail.com", "tester", "napi"))
			{
				System.out.println("Auditor Succcessfully created.");
			}else{
				System.out.println("Some errror while creating auditor information.");
			}
		} catch (mamException e) {
			// TODO Auto-generated catch block
			System.out.println("mamException: " + e.getMessage());
		} catch (mamThrowableException e) {
			// TODO Auto-generated catch block
			System.out.println("mamThrowableException: " + e.getMessage() + e.getCause());
		}
	}

}
