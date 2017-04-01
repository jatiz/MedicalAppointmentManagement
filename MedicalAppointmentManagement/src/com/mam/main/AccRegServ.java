package com.mam.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mam.customexception.mamException;
import com.mam.services.accountCreationServices;

/**
 * Servlet implementation class AccRegServ
 */
@WebServlet("/AccRegServ")
public class AccRegServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccRegServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		accountCreationServices accCreateserv = new accountCreationServices();
		try {
			if (accCreateserv.accountCreate("Hanafi", "Yakub", "napi1@mail.com", "passwd")) {
				// System.out.println("Account Successfully Created");
				response.getWriter().println("Account Successfully Created");
				response.getWriter().println("Job well done.");
			} else {
				// System.out.println("Validation Failed!");
				response.getWriter().println("Validation Failed!");
			}
		} catch (mamException e) {
			// TODO Auto-generated catch block
			response.getWriter().println(e.getMessage() + " " + e.getCause());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
