package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./logins");
		if (httpSession.getAttribute("loggedin") == null) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<p>Please login.</p>");
			requestDispatcher.include(request, response);
		}
		else {
			httpSession.removeAttribute("loggedin");
			httpSession.invalidate();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<p>Loggedout. Please login.</p>");
			requestDispatcher.include(request, response);
		}
	}

}
