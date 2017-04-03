package com.mam.main;


import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;
import com.mam.services.accountCreationServices;

/*
 * Servlet representation
 */


public class servletSimulationAccountCreation{

	public static void main(String[] args) {		//Represent a servlet #act as the front-end 
		accountCreationServices accCreateserv = new accountCreationServices();
			try {
				if(accCreateserv.accountCreate("Khairi", "Yakub", "anonymousjatiz@gmail.com", "321227ys")){
					System.out.println("Account Successfully Created");
				}else{
					System.out.println("Validation Failed!");
				}
			} catch (mamException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} catch (mamThrowableException e) {
				// TODO Auto-generated catch block
				System.out.println("mamThrowableException:" + e.getCause());
			}
		
	}

}
