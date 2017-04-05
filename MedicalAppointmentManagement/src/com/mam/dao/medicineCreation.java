package com.mam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mam.bean.medicineObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;

public class medicineCreation {

	private dbConnect dbConn = new dbConnect();
	private String sql;
	PreparedStatement ps;
	ResultSet rs;
	
	public void medicineCreate(medicineObj medObj) throws mamException, mamThrowableException{
		sql = "insert into medication (medicineID, medicineName, medicineDesc, patientID, appointmentID, remark, quantity) VALUES (?,?,?,?,?,?,?)";
		try {
			dbConn.getConnect(); // Create connection to database
			ps = dbConn.requestConnect().prepareStatement(sql);
			ps.setString(1, medObj.getMedicineID());
			ps.setString(2, medObj.getMedicineName());
			ps.setString(3, medObj.getMedicineDesc());
			ps.setString(4, medObj.getPatientID());
			ps.setString(5, medObj.getAppointmentID());
			ps.setString(6, medObj.getRemark());
			ps.setInt(7, medObj.getQuantity());
			int query = ps.executeUpdate();
			if (query > 0) {
				// System.out.println("Account Successfully Created");
			} else {
				System.out.println("Error under medicineCreation query prep statement");
			}
			dbConn.requestConnect().close();
		} catch (SQLException e) {
			// System.out.println("'accountCreation SQLEXCEPTION ERROR: " + e);
			throw new mamThrowableException("'medicineCreation SQLEXCEPTION ERROR: ", e);
		} catch (Exception e) {
			// System.out.println("'accountCreation EXCEPTION ERROR: " + e);
			throw new mamThrowableException("'medicineCreation EXCEPTION ERROR: ", e);
		}
	}
	
	public void medicineCreateWithoutAppointment(medicineObj medObj) throws mamException, mamThrowableException{
		sql = "insert into medication (medicineID, medicineName, medicineDesc, patientID, remark, quantity) VALUES (?,?,?,?,?,?)";
		try {
			dbConn.getConnect(); // Create connection to database
			ps = dbConn.requestConnect().prepareStatement(sql);
			ps.setString(1, medObj.getMedicineID());
			ps.setString(2, medObj.getMedicineName());
			ps.setString(3, medObj.getMedicineDesc());
			ps.setString(4, medObj.getPatientID());
			ps.setString(5, medObj.getRemark());
			ps.setInt(6, medObj.getQuantity());
			int query = ps.executeUpdate();
			if (query > 0) {
				// System.out.println("Account Successfully Created");
			} else {
				System.out.println("Error under medicineCreation query prep statement");
			}
			dbConn.requestConnect().close();
		} catch (SQLException e) {
			// System.out.println("'accountCreation SQLEXCEPTION ERROR: " + e);
			throw new mamThrowableException("'medicineCreation SQLEXCEPTION ERROR: ", e);
		} catch (Exception e) {
			// System.out.println("'accountCreation EXCEPTION ERROR: " + e);
			throw new mamThrowableException("'medicineCreation EXCEPTION ERROR: ", e);
		}
	}
}
