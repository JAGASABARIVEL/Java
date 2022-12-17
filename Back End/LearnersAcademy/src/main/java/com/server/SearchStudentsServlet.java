package com.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDao;
import com.entity.Student;

public class SearchStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentDao studentDao = new StudentDao();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    HttpSession httpSession = request.getSession();
		    
		    if (httpSession.getAttribute("loggedin") == null) {
		    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("./logins");
				requestDispatcher.forward(request, response);
			}
		    else {
		    	String name = request.getParameter("name");
				List<Student> students = studentDao.fetch(name);
				httpSession.setAttribute("students", students);

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("SearchStudent.jsp");
				requestDispatcher.forward(request, response);
		    }
	}

}
