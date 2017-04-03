package com.mam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;

public class retrieveUserID {

	private dbConnect dbConn = new dbConnect();
	private String sql = "select accID from account where email=?";
	PreparedStatement ps;
	ResultSet rs;
	
	public String retrieveID(String email) throws mamException, mamThrowableException{
		String AccID = "null";
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
}
