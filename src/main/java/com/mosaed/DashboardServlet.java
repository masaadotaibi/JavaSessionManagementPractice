package com.mosaed;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Cookie [] cookies = req.getCookies();
		
		String username = "";
		String password = "";
			
		for(Cookie c: cookies) {
			if(c.getName().equals("username")) {
				username = c.getValue();
				System.out.println("Username => " + username);
			}
			if(c.getName().equals("password")) {
				password = c.getValue();
				System.out.println("Password => " + password);
			}
		}
		
		PrintWriter out = res.getWriter();
		
		out.println("Hi " + username + ". You had a successful login in " + new Date());
		out.println("Your current password is => " + password);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
