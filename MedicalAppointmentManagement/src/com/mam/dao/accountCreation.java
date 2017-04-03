package com.mam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mam.bean.accountObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;

public class accountCreation {

	private dbConnect dbConn = new dbConnect();
	private String sql = "insert into account (accID, firstName, lastName, email, password) VALUES (?,?,?,?,?)";
	PreparedStatement ps;
	ResultSet rs;

	public void accountCreate(accountObj accObj) throws SQLException, mamException, mamThrowableException{
		try {
			dbConn.getConnect(); // Create connection to database
			ps = dbConn.requestConnect().prepareStatement(sql);
			ps.setString(1, accObj.getAccID()); // Generate random number #Check database before inserting
			ps.setString(2, accObj.getFirstName());
			ps.setString(3, accObj.getLastName());
			ps.setString(4, accObj.getEmail());
			ps.setString(5, accObj.getPassword()); // Generate MD5 Hashing
													// before inserting
			int query = ps.executeUpdate();
			if (query > 0) {
				// System.out.println("Account Successfully Created");
			} else {
				System.out.println("Error under accountCreation query prep statement");
			}
			dbConn.requestConnect().close();
		} catch (SQLException e) {
			// System.out.println("'accountCreation SQLEXCEPTION ERROR: " + e);
			throw new mamThrowableException("'accountCreation SQLEXCEPTION ERROR: ", e);
		} catch (Exception e) {
			// System.out.println("'accountCreation EXCEPTION ERROR: " + e);
			throw new mamThrowableException("'accountCreation EXCEPTION ERROR: ", e);
		}
	}

	// database validation
	public boolean checkAccID(String accID) throws mamException, mamThrowableException {

		String query = "select accID from account where accID=?";
		try {
			dbConn.getConnect();
			ps = dbConn.requestConnect().prepareStatement(query);
			ps.setString(1, accID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return true; // have duplicate
			}
			dbConn.requestConnect().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("AccID Error in SQLException : " + e);	//Custom Exception needed
			throw new mamThrowableException("AccID Error in SQLException : ", e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("AccID Error in Exception : " + e);	//Custom Exception needed
			throw new mamThrowableException("AccID Error in Exception : ", e);
		} // Create connection to database

		return false; // no duplicate
	}

	public boolean checkEmailDuplicate(String email) throws mamException, mamThrowableException {
		String query = "select email from account where email=?";
		try {
			dbConn.getConnect();
			ps = dbConn.requestConnect().prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				return true; // have duplicate
			}
			dbConn.requestConnect().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("Email ERROR in SQLException : " + e);		//Custom Exception needed
			throw new mamThrowableException("Email ERROR in SQLException : ", e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("Email ERROR in Genaral Exception : " + e);	//Custom Exception needed
			throw new mamThrowableException("Email ERROR in Genaral Exception : ", e);
		}
		return false; // no duplicate
	}

}
