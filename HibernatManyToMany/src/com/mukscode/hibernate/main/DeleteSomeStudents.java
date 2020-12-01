package com.mukscode.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mukscode.hibernate.entity.Course;
import com.mukscode.hibernate.entity.Instructor;
import com.mukscode.hibernate.entity.InstructorDetail;
import com.mukscode.hibernate.entity.Review;
import com.mukscode.hibernate.entity.Student;


public class DeleteSomeStudents {

public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try 
		{

			//start transaction
			session.beginTransaction();
			
			//get the student ram from db
			int theId = 1;
			int theId2 = 7;
			Student theStudent = session.get(Student.class, theId);
			Student theStudent2 = session.get(Student.class, theId2);
			
			System.out.println("Stuent is: "+theStudent);
			System.out.println("Stuent is: "+theStudent2);
			
			//delete the students
			System.out.println("Deleting students: "+theStudent+" "+theStudent2);
			session.delete(theStudent);
			session.delete(theStudent2);
			
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		finally 
		{
			factory.close();
		}
		
	}

}
