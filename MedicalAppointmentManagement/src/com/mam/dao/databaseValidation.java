package com.mam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mam.bean.patientObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;

public class databaseValidation {
	
	private dbConnect dbConn = new dbConnect();
	private String query = "select firstName, lastName, DOB from patient where firstName=? and lastName=? and DOB=?";
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean checkPatientAccount(patientObj patient) throws mamException, mamThrowableException{
		
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
}