package com.mam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mam.bean.appointmentObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;

public class appointmentCreation {

	private dbConnect dbConn = new dbConnect();
	private String sql = "insert into appointment (appointmentID, appointmentName, appointmentDesc, patientID, date, time, venue) VALUES (?,?,?,?,?,?,?)";
	PreparedStatement ps;
	ResultSet rs;

	public void createAppointment(appointmentObj apptObj) throws mamException, mamThrowableException{
		try {
			dbConn.getConnect(); // Create connection to database
			ps = dbConn.requestConnect().prepareStatement(sql);
			ps.setString(1, apptObj.getAppointmentID());
			ps.setString(2, apptObj.getAppointmentName());
			ps.setString(3, apptObj.getAppointmentDesc());
			ps.setString(4, apptObj.getPatientID());
			ps.setString(5, apptObj.getDate());
			ps.setString(6, apptObj.getTime());
			ps.setString(7, apptObj.getVenue());
			
			int query = ps.executeUpdate();
			if (query > 0) {
				// System.out.println("Account Successfully Created");
			} else {
				System.out.println("Error under appointmentCreation query prep statement");
			}
			dbConn.requestConnect().close();
		} catch (SQLException e) {
			// System.out.println("'accountCreation SQLEXCEPTION ERROR: " + e);
			throw new mamThrowableException("'appointmentCreation SQLEXCEPTION ERROR: ", e);
		} catch (Exception e) {
			// System.out.println("'accountCreation EXCEPTION ERROR: " + e);
			throw new mamThrowableException("'appointmentCreation EXCEPTION ERROR: ", e);
		}
	}
	
}
