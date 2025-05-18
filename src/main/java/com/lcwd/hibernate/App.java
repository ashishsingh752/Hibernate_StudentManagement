package com.lcwd.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lcwd.hibernate.entities.Student;
import com.lcwd.hibernate.util.SessionProvider;


public class App 
{
    public static void main( String[] args ){
    	
        System.out.println( "Hello World! I'm learning Hibernate" );        
        
        Student student = new Student();
        
        student.setName("Ashish Singh");
        student.setCollegeName("NIT Rourkela");
        student.setFather("Purushottam Singh");
        student.setPhone("9125993492");
        student.setActive(false);
        student.setAbout("Electrical Engineer");
        
        SessionFactory sessionFactory = SessionProvider.getSessionFactory();
//        System.out.println(sessionFactory);
        Session session = sessionFactory.openSession();
        
        Transaction transaction = null;
        
        try {
			transaction = session.beginTransaction();
			session.persist(student);
			System.out.println("Student Saved Successfully");
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			System.out.println("error:  " + e.getMessage());
			e.printStackTrace();
		} finally {
			session.close();
		}
        
    }
}
