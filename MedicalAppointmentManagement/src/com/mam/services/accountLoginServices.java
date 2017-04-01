package com.mam.services;

import java.sql.SQLException;

import com.mam.bean.accountObj;
import com.mam.customexception.mamException;
import com.mam.dao.accountLogin;
import com.mam.validation.accountValidate;

public class accountLoginServices {

	private accountObj accObj = new accountObj();
	private accountValidate accValid = new accountValidate();
	private accountLogin userLogin = new accountLogin();
	
	public boolean loginUser(String email, String pass) throws mamException{
		
		accObj.setEmail(email);
		accObj.setPassword(accValid.passwordHashing(pass));
			try {
				if(userLogin.getLogin(accObj)){
					return true;
				}
			} catch (mamException e) {
				// TODO Auto-generated catch block
				throw new mamException("Exception ERROR at accountLoginServices:", e);
			}
		return false;
		
	}
	
}
