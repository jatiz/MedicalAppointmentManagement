package com.mam.main;

import java.util.Scanner;

import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;
import com.mam.services.accountLoginServices;

/*
 * Servlet representation
 */

public class servletSimulationUserLogin {	//Represent a servlet #act as the front-end

	static String email="";	//"anonymousjatiz@gmail.com"
	static String password="";	//"321227ys"
	
	public static void main(String[] args) {

		accountLoginServices accLogin = new accountLoginServices();
			Scanner scn = new Scanner(System.in);
			System.out.print("Enter your email: ");
			email = scn.next();
			System.out.print("Enter your password: ");
			password = scn.next();
			scn.close();
			
			try {
				if(accLogin.loginUser(email, password)){
					System.out.println("User Successfully login!");
				}else{
					System.out.println("Incorrect email or password.");
				}
			} catch (mamException e) {
				// TODO Auto-generated catch block
				System.out.println("Custom Exception:- \n");
				System.out.println(e);
			} catch (mamThrowableException e) {
				// TODO Auto-generated catch block
				System.out.println("mamThrowableException:" + e.getCause());
			}
		
	}

}
