package com.mam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;

public class retrieveID {

	private dbConnect dbConn = new dbConnect();
	private String sql;
	PreparedStatement ps;
	ResultSet rs;
	
	public String retrieveUserID(String email) throws mamException, mamThrowableException{
		String AccID = "null";
		sql = "select accID from account where email=?";
		try {
			dbConn.getConnect();
			ps = dbConn.requestConnect().prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()){
				AccID = Integer.toString(rs.getInt("accID"));
			}
			
		} catch (mamException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new mamThrowableException("SQL ERROR in retrieving AccID", e);
		}
		return AccID;
	}
	
	public String retrivePatientID(String name) throws mamException, mamThrowableException{
		String patientID = "null";
		sql = "select patientID from patient where firstName=?";
		try {
			dbConn.getConnect();
			ps = dbConn.requestConnect().prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()){
				patientID = Integer.toString(rs.getInt("patientID"));
			}
			
		} catch (mamException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new mamThrowableException("SQL ERROR in retrieving patient ID", e);
		}
		
		return patientID;
		
	}
	
	public String retriveAppointmentID(String name) throws mamException, mamThrowableException{
		String apptID = "null";
		sql = "select appointmentID from appointment where appointmentName=?";
		try {
			dbConn.getConnect();
			ps = dbConn.requestConnect().prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()){
				apptID = Integer.toString(rs.getInt("appointmentID"));
			}
			
		} catch (mamException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new mamThrowableException("SQL ERROR in retrieving appointment ID", e);
		}
		
		return apptID;
		
	}
}
