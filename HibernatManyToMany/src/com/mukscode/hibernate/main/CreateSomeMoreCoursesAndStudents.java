package com.mukscode.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mukscode.hibernate.entity.Course;
import com.mukscode.hibernate.entity.Instructor;
import com.mukscode.hibernate.entity.InstructorDetail;
import com.mukscode.hibernate.entity.Review;
import com.mukscode.hibernate.entity.Student;


public class CreateSomeMoreCoursesAndStudents {

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
			int theId = 2;
			Student theStudent = session.get(Student.class, theId);
			
			System.out.println(theStudent);
			
			//create some more courses
			Course theCourse = new Course("How to kill Ravan");
			Course theCourse2 = new Course("How to break bow");
			
			//add student to courses
			theCourse.addStudent(theStudent);
			theCourse2.addStudent(theStudent);
			
			//save the courses
			System.out.println("Saving the Courses");
			session.save(theCourse);
			session.save(theCourse2);
			
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
