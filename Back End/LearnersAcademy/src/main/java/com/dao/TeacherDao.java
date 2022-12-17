package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Classes;
import com.entity.Config;
import com.entity.Subject;
import com.entity.Teacher;

public class TeacherDao {
	public void insert(Teacher teacher, Subject subject, Classes classes) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			teacher.setSubjects(subject);
			teacher.setClasses(classes);
			subject.setTeacher(teacher);
			classes.setTeachers(teacher);
			session.save(teacher);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
		}
		finally {
			session.close();
		}
	}
}
