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
import com.mam.services.accountLoginServices;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		accountLoginServices accLogin = new accountLoginServices();
		
			try {
				
				String username = "anonymousjatiz@gmail.com";
				String pass = "321227ys";
				
				if(accLogin.loginUser(username, pass)){
					HttpSession session = request.getSession();
					session.setAttribute("uname", username);
					response.setContentType("text/html");
					out.println("<p>User Successfully Logged In!</p>");
					out.print("<a href='DashboardServ'>visit</a>");  
					out.close();  
				}else{
					out.print("Invalid email or password");
				}
			} catch (mamException e) {
				// TODO Auto-generated catch block
				out.println(e.getMessage());
			} catch (mamThrowableException e) {
				// TODO Auto-generated catch block
				out.println(e.getMessage() + ": " + e.getCause());
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
