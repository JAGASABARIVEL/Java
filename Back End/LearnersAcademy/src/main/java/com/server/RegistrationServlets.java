package com.server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entity.User;

public class RegistrationServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDao();
	User user;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		user = new User(name, phone, password);
		
		HttpSession httpSession = request.getSession();
		System.out.println("httpSession : " + httpSession.getAttribute("loggedin"));
		
		if (httpSession.getAttribute("loggedin") != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
			requestDispatcher.forward(request, response);
		}
		else if (name == null || phone == null || password == null || name.trim().length() == 0 || phone.trim().length() == 0 || password.trim().length() == 0) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Registration.html");
			requestDispatcher.forward(request, response);
		}
		else if (userDao.registration(user) == true) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
			requestDispatcher.forward(request, response);
		}
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
			requestDispatcher.forward(request, response);
			
		}
	}

}
