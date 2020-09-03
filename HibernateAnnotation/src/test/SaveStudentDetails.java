package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student;

public class SaveStudentDetails {

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Student s1 = new Student();
		s1.setStudentId(1);
		s1.setStudentName("Ramesh");
		s1.setStudentpercentage(63.67);
		s1.setStudentStream("COM");
		
	
		
		tx=ses.beginTransaction();
		
		ses.save(s1);
		
		
		
		tx.commit();
		
		System.out.println("Student details inserted succesfully");

	}

}
