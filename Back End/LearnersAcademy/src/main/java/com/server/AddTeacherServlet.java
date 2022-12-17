package com.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TeacherRegistrationDao;
import com.entity.MamRegistration;

public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("loggedin") == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./logins");
			requestDispatcher.forward(request, response);
		} else if (name == null || name.trim().length() == 0) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddTeacher.html");
			requestDispatcher.forward(request, response);
		} else {
			MamRegistration mam = new MamRegistration(name);
			TeacherRegistrationDao teacherRegistrationDao = new TeacherRegistrationDao();
			teacherRegistrationDao.insert(mam);
			List<MamRegistration> teacherlist = teacherRegistrationDao.fetch();
			httpSession.setAttribute("teacherlist", teacherlist);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddDetails.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
