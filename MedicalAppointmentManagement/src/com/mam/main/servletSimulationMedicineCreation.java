package com.mam.main;

import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;
import com.mam.services.medicineCreationServices;

public class servletSimulationMedicineCreation {
	
	public static void main(String[] args) {
	
		medicineCreationServices medCreateServices = new medicineCreationServices();
		
		try {
			//if(medCreateServices.medicineCreate("Panadol", "relief headache", "napi", "Cramp", "2 tablets for adult, 1 tablet for kids", 2))
			if(medCreateServices.medicineCreateWithoutAppointment("Panadol", "relief headache", "napi", "2 tablets for adult, 1 tablet for kids", 3))
			{
				System.out.println("Medicince successfully created");
			}else{
				System.out.println("Medicine has been added in the database");
			}
		} catch (mamException e) {
			// TODO Auto-generated catch block
			System.out.println("mamException ERROR: " + e.getMessage());
		} catch (mamThrowableException e) {
			// TODO Auto-generated catch block
			System.out.println("mamThrowableException ERROR: " + e.getMessage() + e.getCause());
		}
		
		
	}

}
