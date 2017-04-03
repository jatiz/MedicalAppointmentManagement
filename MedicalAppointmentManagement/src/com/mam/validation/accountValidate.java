package com.mam.validation;



import com.mam.bean.accountObj;
import com.mam.customexception.mamException;
import com.mam.encryption.md5encryption;

public class accountValidate {

	private accountObj newAccObj;
	private String alphaPattern = "[a-zA-Z]+";

	public boolean validateAll(accountObj accObj) throws mamException { // Check all Validations
		newAccObj = accObj;
		if (validateName()) {
			try {
				if (validateEmail()) {
					System.out.println("return true :validateAll");
					return true;
				} else {
					return false;
				}
			} catch (mamException e) {
				// TODO Auto-generated catch block
				throw e;
			}
		} else {
			return false;
		}

		/*
		 * if (validateEmail()) { if (validateName()) {
		 * System.out.println("return true :validateAll"); return true; }else{
		 * System.out.println("return false :validateAll"); return false; } }
		 * else { System.out.println("return false :validateAll"); return false;
		 * }
		 */

	}

	public boolean validateName() throws mamException {

		if (newAccObj.getFirstName().matches(alphaPattern)) {
			System.out.println("return true :valideteFirstName");
			if (newAccObj.getLastName().matches(alphaPattern)) {
				System.out.println("return true :validateLastName");
				return true;
			} else {
				System.out.println("LastName validation error");
				throw new mamException("LastName validation error");
			}
		} else {
			System.out.println("FirstName validation error");
			throw new mamException("FirstName validation error");
		}
	}

	public boolean validateEmail() throws mamException { // Email validation
		if (newAccObj.getEmail().indexOf('@') >= 0) {
			System.out.println("return true :validateEmail");	//Custom Exception needed
			return true;
		} else {
			System.out.println("return false :validateEmail: REASON:: '@' symbol is require for email address.");	//Custom Exception needed
			throw new mamException("Validation Failed.\n REASON:: '@' symbol is require for email address.");
		}
	}

	public void passwordHashing() {
		String hashedPassword;
		hashedPassword = md5encryption.getHash(newAccObj.getPassword().getBytes());
		newAccObj.setPassword(hashedPassword);
	}
	
	public String passwordHashing(String pass) {
		String hashedPassword;
		hashedPassword = md5encryption.getHash(pass.getBytes());
		return hashedPassword;
	}

	

}
