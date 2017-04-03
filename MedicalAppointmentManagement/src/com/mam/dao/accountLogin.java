package com.mam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mam.bean.accountObj;
import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;

public class accountLogin {

	private dbConnect dbConn = new dbConnect();
	private String query = "select email, password from account where email=? and password=?";
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean getLogin(accountObj accObj) throws mamException, mamThrowableException{
				try {
					dbConn.getConnect();
					ps = dbConn.requestConnect().prepareStatement(query);
					ps.setString(1, accObj.getEmail());
					ps.setString(2, accObj.getPassword());
					rs = ps.executeQuery();
					while(rs.next()){
						return true;
					}
					dbConn.requestConnect().close();
				} catch (mamException e) {
					// TODO Auto-generated catch block
					throw e;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new mamThrowableException("Exception ERROR at AccountLogin:", e);
				}
				
			
		return false;
	}
	
}
