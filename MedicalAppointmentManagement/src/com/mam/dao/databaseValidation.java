package com.mam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mam.bean.appointmentObj;
import com.mam.bean.auditorObj;
import com.mam.bean.medicineObj;
import com.mam.bean.patientObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;

public class databaseValidation {
	
	private dbConnect dbConn = new dbConnect();
	private String query;
	private PreparedStatement ps;
	private ResultSet rs;
	
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
	
	public boolean checkMedicineRecord(medicineObj medObj) throws mamException, mamThrowableException{
		query = "select medicineName, appointmentID, patientID from medication where medicineName=? and patientID=? and appointmentID=?";
		
		try {
			dbConn.getConnect();
			ps = dbConn.requestConnect().prepareStatement(query);
			ps.setString(1, medObj.getMedicineName());
			ps.setString(3, medObj.getPatientID());
			ps.setString(2, medObj.getAppointmentID());
			rs = ps.executeQuery();
			while(rs.next()){
				//throw new mamException("This medicine has been added into the database for this patient reference with the selected appointment");
				return true;
			}
		} catch (mamException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new mamThrowableException("SQL ERROR for checking medicine in database", e);
		}
		
		return false;
	}
	
	public boolean checkMedicineRecordWithoutAppointmentID(medicineObj medObj) throws mamException, mamThrowableException{
		query = "select medicineName, appointmentID, patientID from medication where medicineName=? and patientID=?";
		
		try {
			dbConn.getConnect();
			ps = dbConn.requestConnect().prepareStatement(query);
			ps.setString(1, medObj.getMedicineName());
			ps.setString(2, medObj.getPatientID());
			rs = ps.executeQuery();
			while(rs.next()){
				//throw new mamException("This medicine has been added into the database for this patient reference with the selected appointment");
				return true;
			}
		} catch (mamException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new mamThrowableException("SQL ERROR for checking medicine in database", e);
		}
		
		return false;
	}
	
	public boolean checkAuditorGrpName(auditorObj auditObj) throws mamException, mamThrowableException{
		query = "select auditorGrpName from auditor where accID=? and patientID=?";
		
		try {
			dbConn.getConnect();
			ps = dbConn.requestConnect().prepareStatement(query);
			ps.setString(1, auditObj.getAccID());
			ps.setString(2, auditObj.getPatientID());
			rs = ps.executeQuery();
			while(rs.next()){
				return true;
			}
		} catch (mamException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new mamThrowableException("SQL ERROR for checking auditorGrpName in database", e);
		}
		
		return false;
	}
	
	public boolean checkPatientLinkToUser(String patientName, String careGiver) throws mamException, mamThrowableException{
		query = "select patientID from patient where firstName=? and careGiver=?";
		
		try {
			dbConn.getConnect();
			ps = dbConn.requestConnect().prepareStatement(query);
			ps.setString(1, patientName);
			ps.setString(2, careGiver);
			rs = ps.executeQuery();
			while(rs.next()){
				return true;
			}
		} catch (mamException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new mamThrowableException("SQL ERROR for checking patient link in database", e);
		}
		
		return false;
	}
}
