package com.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ClassesDao;
import com.entity.Classes;

public class ClassDetailServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ClassesDao classesDao = new ClassesDao();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("loggedin") == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./logins");
			requestDispatcher.forward(request, response);
		} else {
			List<Classes> students = classesDao.fetch();
			httpSession.setAttribute("Classes", students);

			int listlength = students.size();
			for (int index = 0; index < listlength; index++) {
				System.out.println("cname : " + students.get(index).getCname());
				System.out.println("stname : " + students.get(index).getStudents());
				System.out.println("sname : " + students.get(index).getSubjects());
				System.out.println("tname:" + students.get(index).getTeachers());

			}

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ClassDetail.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
