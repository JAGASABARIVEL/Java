package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Classes;
import com.entity.Config;
import com.entity.Subject;
import com.entity.Teacher;

public class SubjectDao {
	public void insert(Subject subject, Teacher teacher, Classes classes) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			subject.setClasses(classes);
			subject.setTeacher(teacher);
			classes.setSubjects(subject);
			teacher.setSubjects(subject);
			session.save(subject);
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
