package com.mam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mam.customexception.mamException;

public class dbConnect {		//Connection to database
	
	private Connection conn;
	
	public void getConnect() throws mamException{		//Need to use properties file for better management
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/mediacalappointmentmanagement","root","root");
		} catch (SQLException e) {
			System.out.println("SQL Exception ERROR at dbConnect\n");
			throw new mamException("SQL Exception ERROR at dbConnect:", e);
		}catch(Exception e){
			System.out.println("Exception ERROR at dbConnect\n");
			throw new mamException("Exception ERROR at dbConnect:", e);
		}
		
	}
	
	public Connection requestConnect(){
		return conn;
	}
	
}
