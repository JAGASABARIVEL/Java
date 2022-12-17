package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entity.User;
import com.service.Authentication;

public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDao();
	User user;
	
	private void login(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws ServletException, IOException{
		httpSession.setAttribute("loggedin", true);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
		requestDispatcher.forward(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession();
		
		user = new User(request.getParameter("phone"), request.getParameter("password"));
		if (httpSession.getAttribute("loggedin") != null) {
			login(request, response, httpSession);
		}
		
		else if (userDao.fetchApi(user) == null) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
			requestDispatcher.include(request, response);
			out.println("<p align=\"centre\">Please <a href=\"./registrations\">register</a> if you are not registerd.");
		}
		else if(Authentication.validate(user) == false) {
			PrintWriter out = response.getWriter();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
			requestDispatcher.include(request, response);
			out.println("<p align=\"centre\">Phone or Password is not right.");
		}
		else {
			login(request, response, httpSession);
		}
	}

}
