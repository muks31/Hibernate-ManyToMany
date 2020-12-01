package com.mukscode.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mukscode.hibernate.entity.Course;
import com.mukscode.hibernate.entity.Instructor;
import com.mukscode.hibernate.entity.InstructorDetail;
import com.mukscode.hibernate.entity.Review;
import com.mukscode.hibernate.entity.Student;


public class DeleteACourse {

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
			
			//get a Course from db
			int theCourseId = 12;
			Course theCourse = session.get(Course.class, theCourseId);
			
			System.out.println("Course is: "+theCourse);
			
			//delete the course
			System.out.println("Deleting the course: "+theCourse);
			
			session.delete(theCourse);
			
			
			
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
