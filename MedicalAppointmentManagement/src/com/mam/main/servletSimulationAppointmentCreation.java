package com.mam.main;

import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;
import com.mam.services.appointmentCreationServices;

public class servletSimulationAppointmentCreation {

	private static appointmentCreationServices apptCreateService = new appointmentCreationServices();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			if(apptCreateService.appointmentCreate("Cramp", "khai", "2017", "06", "4", "3:15 am", "Woodlands Polyclinic", "Cannot sleep")){
				System.out.println("Appointment recorded");	//15:02:28 3:02 pm
			}else{
				System.out.println("Appointment not recorded");
			}
		} catch (mamException e) {
			System.out.println("mamException ERROR: " + e.getMessage());
		} catch (mamThrowableException e) {
			// TODO Auto-generated catch block
			System.out.println("mamThrowableException ERROR: " + e.getMessage() + ":- " + e.getCause());
		}
		
	}

}
