package com.server;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.ClassRegistrationDao;
import com.dao.ClassesDao;
import com.dao.StudentRegistrationDao;
import com.dao.SubjectRegistrationDao;
import com.dao.TeacherRegistrationDao;
import com.entity.Classes;
import com.entity.Config;
import com.entity.Student;
import com.entity.StudentRegistration;
import com.entity.Subject;
import com.entity.Teacher;

public class AddServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String tId = request.getParameter("teacher");
		String stId = request.getParameter("student");
		String cId = request.getParameter("class");
		String sId = request.getParameter("subject");

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("loggedin") == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./logins");
			requestDispatcher.forward(request, response);
		} else if(tId == null || stId == null || cId == null || sId == null ||
				tId.trim().length() == 0 || stId.trim().length() == 0 ||
				cId.trim().length() == 0 || sId.trim().length() == 0) {
			
			
			httpSession.setAttribute("studentlist", new StudentRegistrationDao().fetch());
			httpSession.setAttribute("teacherlist", new TeacherRegistrationDao().fetch());
			httpSession.setAttribute("subjectlist", new SubjectRegistrationDao().fetch());
			httpSession.setAttribute("classlist", new ClassRegistrationDao() .fetch());
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddDetails.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			Student student = new Student();
			Subject subject = new Subject();
			Classes classes = new Classes();
			Teacher teacher = new Teacher();
			ClassesDao classesDao = new ClassesDao();

			

			student.setStname(stId);
			teacher.setTname(tId);
			classes.setCname(cId);
			subject.setSname(sId);

			classesDao.insert(classes, subject, teacher, student);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./classDetails");
			requestDispatcher.forward(request, response);
		}
	}
}