package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Classes;
import com.entity.Config;
import com.entity.Student;

public class StudentDao {

	public void insert(Student student, Classes classes) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			student.setClasses(classes);
			classes.setStudents(student);
			session.save(student);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public Student fetch() {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();

		Student student = session.get(Student.class, 2);
		return student;
	}
	
	public List<Student> fetch(String name) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();

		String q = "select s from Student s where s.stname like :name";
		Query query = session.createQuery(q);
		query.setParameter("name", name);
		List<Student> student = query.getResultList();
		return student;
	}
}
