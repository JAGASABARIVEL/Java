package com.dao;

import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Config;
import com.entity.User;

public class UserDao {
	
	private void insert(User user) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			session.close();
		}
	}
	
	public User fetchApi(User user) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<User> fuserc = fetch(user);
		session.close();
		if (fuserc.size() == 0) {
			return null;
		}
		return fuserc.get(0);
	}
	
	private List<User> fetch(User user) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		String phone = user.getPhone();
		Query query = session.createQuery("select u from User u where u.phone like :phone");
		query.setParameter("phone", phone);
		
		List<User> users = query.getResultList();
		session.close();
		return users;
	}
	
	public boolean registration(User user) {
		User ruser = fetchApi(user);
		if (ruser == null) {
			insert(user);
			return true;
		}
		else {
			return false;
		}
	}
}
