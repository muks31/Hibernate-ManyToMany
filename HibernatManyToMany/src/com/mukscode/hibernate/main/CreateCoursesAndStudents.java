package com.mukscode.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mukscode.hibernate.entity.Course;
import com.mukscode.hibernate.entity.Instructor;
import com.mukscode.hibernate.entity.InstructorDetail;
import com.mukscode.hibernate.entity.Review;
import com.mukscode.hibernate.entity.Student;


public class CreateCoursesAndStudents {

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
			
			//create a course
			Course theCourse = new Course("How to Kill people without getting caught");
			
			//save the course 
			System.out.println("Saving the course");
			session.save(theCourse);
			System.out.println("saved: "+theCourse);
			
			//create a student
			Student student1 = new Student("Krishna", "Vasudev","harekrishna@gmail.com");
			Student student2 = new Student("Ram", "Dashrath", "thelordram@yahoo.com");
			
			//add students to course
			theCourse.addStudent(student1);
			theCourse.addStudent(student2);
			
			//save the students
			System.out.println("Saving the student");
			session.save(student1);
			session.save(student2);
			
			System.out.println("Students Saved"+theCourse.getStudents());
			
			
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
