package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {

	private ConnectionUtil() {
		super();
	}
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// if no SessionFactory has been created, create one
			Configuration c = new Configuration();
			// grab credentials and url from environment variables
			c.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"));
			c.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));
			c.setProperty("hibernate.connection.url", System.getenv("DB_URL"));
			c.configure(); // by default, looking hibernate.cfg.xml in src/main/resources
			sessionFactory = c.buildSessionFactory();
		}
		return sessionFactory;
}
}
