package com.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentRegistrationDao;
import com.entity.StudentRegistration;

public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("loggedin") == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./logins");
			requestDispatcher.forward(request, response);
		} else if (name == null || name.trim().length() == 0) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddStudent.html");
			requestDispatcher.forward(request, response);
		} else {
			StudentRegistration student = new StudentRegistration(name);
			StudentRegistrationDao studentRegistrationDao = new StudentRegistrationDao();
			studentRegistrationDao.insert(student);
			List<StudentRegistration> studentlist = studentRegistrationDao.fetch();
			httpSession.setAttribute("studentlist", studentlist);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddDetails.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
