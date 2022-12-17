package com.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SubjectRegistrationDao;
import com.entity.SubjectRegistration;

public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("loggedin") == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./logins");
			requestDispatcher.forward(request, response);
		} else if (name == null || name.trim().length() == 0) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddSubject.html");
			requestDispatcher.forward(request, response);
		} else {
			SubjectRegistration subject = new SubjectRegistration(name);
			SubjectRegistrationDao subjectRegistrationDao = new SubjectRegistrationDao();
			subjectRegistrationDao.insert(subject);
			List<SubjectRegistration> subjectlist = subjectRegistrationDao.fetch();
			httpSession.setAttribute("subjectlist", subjectlist);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddDetails.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
