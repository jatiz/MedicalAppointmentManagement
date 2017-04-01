package com.mam.services;

import java.sql.SQLException;

import com.mam.bean.accountObj;
import com.mam.customexception.mamException;
import com.mam.dao.accountCreation;
import com.mam.validation.accountValidate;

public class accountCreationServices {
	
	private accountObj accObj = new accountObj();
	private accountValidate accValid = new accountValidate();
	private accountCreation accCreate = new accountCreation();
	
	
	public boolean accountCreate(String firstName, String lastName, String email, String password) throws mamException{
		accObj.setFirstName(firstName);
		accObj.setLastName(lastName);		//Creating an object
		accObj.setEmail(email);
		accObj.setPassword(password);
		
		if(accValid.validateAll(accObj)){		//Call for validation
			
			//do{
				accValid.passwordHashing();
				int Id = accValid.randomizeAccID();	//generate random 6 digit number
				accObj.setAccID(Integer.toString(Id));	//update account object
				if (!accCreate.checkAccID(accObj.getAccID())){	//check generated id with database for duplicate
					if(!accCreate.checkEmailDuplicate(accObj.getEmail())){	//check email for duplicate
															//Call database for insertion
							try {
								accCreate.accountCreate(accObj);
							} catch (SQLException e) {
								throw new mamException("SQLException ERROR in CreationService:- ",e);
							} catch (mamException e) {
								// TODO Auto-generated catch block
								throw new mamException("SQLException ERROR in CreationService:- ",e);
							}
					}else{
						System.out.println("Email has already registered.");	//Custom Exception needed
						throw new mamException("Email has already registered.");
					}
				}else{
					System.out.println("Internal Error due to account creation: #Account ID");	//Custom Exception needed
					throw new mamException("Internal Error due to account creation: #Account ID");
				}
			//}
			//while(accCreate.checkAccID(accObj.getAccID()));
			
			return true;
		}else{
			return false;
		}
	}
}
