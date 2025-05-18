package com.lcwd.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lcwd.hibernate.entities.Certificate;
import com.lcwd.hibernate.entities.Student;
import com.lcwd.hibernate.util.SessionProvider;


public class App 
{
    public static void main( String[] args ){
    	
        System.out.println( "Hello World! I'm learning Hibernate" );        
        
        Student student = new Student();
        
        student.setName("as");
        student.setCollegeName("NIT Rourkela");
        student.setFather("PS");
        student.setPhone("2323");
        student.setActive(false);
        student.setAbout("Electrical Engineer");
        
        Student student1 = new Student();
        
        student1.setName("AS");
        student1.setCollegeName("IISER Bhopal");
        student1.setFather("Vijay");
        student1.setPhone("7242208");
        student1.setActive(false);
        student1.setAbout("Physicist");
        
        Certificate certificate = new Certificate();
        certificate.setTitle("Marksheet");
        certificate.setAbout("Marksheet for Btech.");
        certificate.setLink("Link");
        
        Certificate certificate1 = new Certificate();
        certificate1.setTitle("Migration");
        certificate1.setAbout("Migration for Btech.");
        certificate1.setLink("Link");
        
        student.getCertificates().add(certificate);
        student.getCertificates().add(certificate1);

        student1.getCertificates().add(certificate);
        student1.getCertificates().add(certificate1);

        certificate.getStudents().add(student);
        certificate.getStudents().add(student1);

        certificate1.getStudents().add(student);
        certificate1.getStudents().add(student1);

        
        SessionFactory sessionFactory = SessionProvider.getSessionFactory();
//        System.out.println(sessionFactory);
        Session session = sessionFactory.openSession();
        
        Transaction transaction = null;
        
        try {
			transaction = session.beginTransaction();
			session.persist(student);
			session.persist(student1);
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
