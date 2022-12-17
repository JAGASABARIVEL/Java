package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Config;
import com.entity.MamRegistration;

public class TeacherRegistrationDao {
	
	public void insert(MamRegistration teacher) {
		SessionFactory sessionFactory = Config.getSessionFactory();
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		session.save(teacher);
    		tx.commit();
    	}
    	catch (Exception e) {
			tx.rollback();
		}
    	finally {
			session.close();
		}
	}
	
	public List<MamRegistration> fetch() {
		SessionFactory sessionFactory = Config.getSessionFactory();
    	Session session = sessionFactory.openSession();
    	
    	List<MamRegistration> teacherlist;
		String select = "select m from MamRegistration m";
		Query query = session.createQuery(select);
		teacherlist = query.getResultList();
		
		return teacherlist;
		
	}
}
