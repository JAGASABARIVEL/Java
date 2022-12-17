package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Classes;
import com.entity.Config;
import com.entity.Student;
import com.entity.Subject;
import com.entity.Teacher;

public class ClassesDao {
	public void insert(Classes classes, Subject subject, Teacher teacher, Student student) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			
			classes.setStudents(student);
			classes.setSubjects(subject);
			classes.setTeachers(teacher);
			
			student.setClasses(classes);
			subject.setClasses(classes);
			teacher.setClasses(classes);
			
			subject.setTeacher(teacher);
			teacher.setSubjects(subject);
			
			
			session.save(classes);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
		}
		finally {
			session.close();
		}
	}
	
	public List<Classes> fetch() {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();

		String q = "select s from Classes s";
		Query query = session.createQuery(q);
		List<Classes> Class = query.getResultList();
		return Class;
	}
}
