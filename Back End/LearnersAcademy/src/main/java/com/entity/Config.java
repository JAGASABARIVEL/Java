package com.entity;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class Config {

	public static SessionFactory  getSessionFactory() {
		Properties properties = new Properties();
		Configuration config = new Configuration();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/systems");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "AmmaAppa==1");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.put(Environment.FORMAT_SQL, "true");
		properties.put(Environment.SHOW_SQL, "true");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		config.setProperties(properties);
		config.addAnnotatedClass(com.entity.Teacher.class);
		config.addAnnotatedClass(com.entity.Classes.class);
		config.addAnnotatedClass(com.entity.Subject.class);
		config.addAnnotatedClass(com.entity.Student.class);
		config.addAnnotatedClass(com.entity.User.class);
		config.addAnnotatedClass(com.entity.StudentRegistration.class);
		config.addAnnotatedClass(com.entity.MamRegistration.class);
		config.addAnnotatedClass(com.entity.SubjectRegistration.class);
		config.addAnnotatedClass(com.entity.ClassRegistration.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		return sessionFactory;
	}
}
