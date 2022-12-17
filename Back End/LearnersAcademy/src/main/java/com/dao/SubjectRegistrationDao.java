package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Config;
import com.entity.SubjectRegistration;

public class SubjectRegistrationDao {
	
	public void insert(SubjectRegistration subject) {
		SessionFactory sessionFactory = Config.getSessionFactory();
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		session.save(subject);
    		tx.commit();
    	}
    	catch (Exception e) {
			tx.rollback();
		}
    	finally {
			session.close();
		}
	}
	
	public List<SubjectRegistration> fetch() {
		SessionFactory sessionFactory = Config.getSessionFactory();
    	Session session = sessionFactory.openSession();
    	
    	List<SubjectRegistration> subjectlist;
		String select = "select m from SubjectRegistration m";
		Query query = session.createQuery(select);
		subjectlist = query.getResultList();
		
		return subjectlist;
		
	}
}
