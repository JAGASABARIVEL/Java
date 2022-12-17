package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Config;
import com.entity.StudentRegistration;

public class StudentRegistrationDao {

	public void insert(StudentRegistration student) {
		SessionFactory sessionFactory = Config.getSessionFactory();
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		session.save(student);
    		tx.commit();
    	}
    	catch (Exception e) {
			tx.rollback();
		}
    	finally {
			session.close();
		}
	}
	
	public List<StudentRegistration> fetch() {
		SessionFactory sessionFactory = Config.getSessionFactory();
    	Session session = sessionFactory.openSession();
    	
    	List<StudentRegistration> studentlist;
		String select = "select s from StudentRegistration s";
		Query query = session.createQuery(select);
		studentlist = query.getResultList();
		
		return studentlist;
		
	}
}
