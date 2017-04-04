package com.mam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mam.bean.appointmentObj;
import com.mam.bean.patientObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;

public class databaseValidation {
	
	private dbConnect dbConn = new dbConnect();
	private String query;
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean checkPatientAccount(patientObj patient) throws mamException, mamThrowableException{		//Checking existing patient
		query = "select firstName, lastName, DOB from patient where firstName=? and lastName=? and DOB=?";
		
		try {
			dbConn.getConnect();
			ps = dbConn.requestConnect().prepareStatement(query);
			ps.setString(1, patient.getFirstName());
			ps.setString(2, patient.getLastName());
			ps.setString(3, patient.getDOB());
			rs = ps.executeQuery();
			while(rs.next()){
				//throw new mamException("This patient has already been registered.");
				return true;
			}
		} catch (mamException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new mamThrowableException("SQL ERROR for checking patient in database", e);
		}
		
		return false;
	}
	
	public boolean checkAppointmentRecord(appointmentObj apptObj) throws mamException, mamThrowableException{
		query = "select appointmentName, date, time, venue from appointment where appointmentName=? and date=? and time=? and venue=?";
		
		try {
			dbConn.getConnect();
			ps = dbConn.requestConnect().prepareStatement(query);
			ps.setString(1, apptObj.getAppointmentName());
			ps.setString(2, apptObj.getDate());
			ps.setString(3, apptObj.getTime());
			ps.setString(4, apptObj.getVenue());
			rs = ps.executeQuery();
			while(rs.next()){
				//throw new mamException("This appointment has been added into the database");
				return true;
			}
		} catch (mamException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new mamThrowableException("SQL ERROR for checking appointment in database", e);
		}
		
		return false;
	}
}
