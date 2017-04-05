package com.mam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mam.bean.auditorObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;

public class auditorCreation {

	private dbConnect dbConn = new dbConnect();
	private String sql = "insert into auditor (auditID, auditorGrpName, accID, patientID) VALUES (?,?,?,?)";
	PreparedStatement ps;
	ResultSet rs;

	public void auditCreate(auditorObj auditObj) throws mamException, mamThrowableException{
		try {
			dbConn.getConnect(); // Create connection to database
			ps = dbConn.requestConnect().prepareStatement(sql);
			ps.setString(1, auditObj.getAuditID());
			ps.setString(2, auditObj.getAuditorGrpName());
			ps.setString(3, auditObj.getAccID());
			ps.setString(4, auditObj.getPatientID());
			int query = ps.executeUpdate();
			if (query > 0) {
				// System.out.println("Account Successfully Created");
			} else {
				System.out.println("Error under auditCreate query prep statement");
			}
			dbConn.requestConnect().close();
		} catch (SQLException e) {
			// System.out.println("'accountCreation SQLEXCEPTION ERROR: " + e);
			throw new mamThrowableException("'auditCreate SQLEXCEPTION ERROR: ", e);
		} catch (Exception e) {
			// System.out.println("'accountCreation EXCEPTION ERROR: " + e);
			throw new mamThrowableException("'auditCreate EXCEPTION ERROR: ", e);
		}
	}
}
