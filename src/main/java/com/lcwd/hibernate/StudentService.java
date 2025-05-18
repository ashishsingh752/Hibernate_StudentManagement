package com.lcwd.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lcwd.hibernate.entities.Student;
import com.lcwd.hibernate.util.SessionProvider;

public class StudentService {

	private SessionFactory sessionFactory = SessionProvider.getSessionFactory();

	// save
	public void saveStudent(Student student) {

		try (Session session = sessionFactory.openSession()) {

			Transaction beginTransaction = session.beginTransaction();
			session.persist(student);
			beginTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// getById
	public Student getStudentById(long studentId) {
		try (Session session = sessionFactory.openSession()) {
			Student student = session.get(Student.class, studentId);
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// update Student
	
	public Student updateStudent(long studentId, Student student) {
		try(Session session = sessionFactory.openSession()) {
				Transaction transaction = session.beginTransaction();
				Student oldStudent = session.get(Student.class, studentId);
				
				if(oldStudent !=null) {
					oldStudent.setName(student.getName());
					oldStudent.setFather(student.getFather());
					oldStudent.setCollegeName(student.getCollegeName());
					oldStudent.setPhone(student.getPhone());
					oldStudent.setAbout(student.getAbout());
					oldStudent.setActive(oldStudent.isActive());
					oldStudent = session.merge(oldStudent);					 
				}
				transaction.commit();
				return oldStudent;				
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// delete 
	
	public void removeStudent(long studentId) {
		try(Session session = sessionFactory.openSession()) {
			
			Transaction transaction = session.beginTransaction();
			
			Student student = session.get(Student.class, studentId);
			if(student!=null) {
				 session.remove(student);
			}
			transaction.commit();			
		} 
	}	
}










