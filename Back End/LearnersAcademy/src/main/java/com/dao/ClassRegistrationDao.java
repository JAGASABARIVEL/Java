package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.ClassRegistration;
import com.entity.Config;

public class ClassRegistrationDao {
	
	public void insert(ClassRegistration classresiRegistration) {
		SessionFactory sessionFactory = Config.getSessionFactory();
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		session.save(classresiRegistration);
    		tx.commit();
    	}
    	catch (Exception e) {
			tx.rollback();
		}
    	finally {
			session.close();
		}
	}
	
	public List<ClassRegistration> fetch() {
		SessionFactory sessionFactory = Config.getSessionFactory();
    	Session session = sessionFactory.openSession();
    	
    	List<ClassRegistration> classlist;
		String select = "select m from ClassRegistration m";
		Query query = session.createQuery(select);
		classlist = query.getResultList();
		
		return classlist;
		
	}
}
