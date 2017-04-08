package com.mam.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;
import com.mam.services.addPatientServices;

/**
 * Servlet implementation class DashboardServ
 */
@WebServlet("/DashboardServ")
public class DashboardServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false); 		//only for displaying the logged in user email address
        String n=(String)session.getAttribute("uname");  
        out.print("<p>Hello "+n+"</p>");
        
        //Simple apache servlet
        addPatientServices patientServices = new addPatientServices();
        try {
			if(patientServices.createPatient(n, "Jatiz", "So", "7", "10", "20070")){		//used for adding new patient
				out.println("Patient Account Successfully Created");
			}else{
				out.println("Patient Account unable to create");
			}
		} catch (mamException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
		} catch (mamThrowableException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage() + ": " + e.getCause());
		}
        
  
        out.close();  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
