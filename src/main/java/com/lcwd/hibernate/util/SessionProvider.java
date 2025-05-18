package com.lcwd.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionProvider {
	private static SessionFactory sessionFactory;
	
	static {
		try {
			if(sessionFactory == null) {
				sessionFactory = new Configuration().configure("hibernate.cnf.xml").buildSessionFactory();
			}
			
		} catch (Exception e) {
			throw new RuntimeException("SessionFactory Error" + e.getMessage()) ;
		}
	}
	// to access the session anywhere
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
