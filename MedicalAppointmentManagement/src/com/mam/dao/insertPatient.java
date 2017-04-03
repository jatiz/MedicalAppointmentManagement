package com.mam.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mam.bean.patientObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;

public class insertPatient {
	
	private dbConnect dbConn = new dbConnect();
	private String sql = "insert into patient (careGiver, patientID, firstName, lastName, DOB) VALUES (?,?,?,?,?)";
	PreparedStatement ps;
	
	public void addPatient(patientObj patient) throws mamException, mamThrowableException{
		try {
			dbConn.getConnect();
			ps = dbConn.requestConnect().prepareStatement(sql);
			ps.setString(1, patient.getCareGiver());
			ps.setString(2, patient.getPatientID());
			ps.setString(3, patient.getFirstName());
			ps.setString(4, patient.getLastName());
			ps.setString(5, patient.getDOB());
			
			int query = ps.executeUpdate();
			if(query > 0){
				//System.out.println("Patient Account Successfully Created");
			}else{
				System.out.println("Error under patient creation query prep statement");
			}
			dbConn.requestConnect().close();
		} catch (mamException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new mamThrowableException("SQL ERROR in insertPatient.java", e);
		}
	}
}
