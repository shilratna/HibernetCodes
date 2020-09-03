package test;

import java.util.List;

// ACCEPT STUDENT ID FROM END USER AND DISPLAY LIST OF ALLOCATED COURSES

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

public class DisplayStudentDetails1 {

	public static void main(String[] args) {
		
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("Enter the student id");
		int id=sc1.nextInt();
		
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Course.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
	
		Student s=ses.get(Student.class, id);
		
		if(s!= null) {
		
		System.out.println("STUDENT NAME IS "+s.getStudentName());
		
		System.out.println("STUDENT EMAIL ID IS "+s.getStudentEmail());
		
		System.out.println("LIST OF ALLOCATED COURSE");
		
		List<Course> courses=s.getCourselist();
		
		for(Course c:courses)
		{
			System.out.println(c.getCourseName());
		}
     
		}
		else
		{
			System.out.println("RECORD NOT FOUND");
		}
		sc1.close();
	}

}
