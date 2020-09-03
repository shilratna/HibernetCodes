package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student;

public class UpdateStudent {

	public static void main(String[] args)
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses =null;
		Transaction tx=null;
		
		cfg = new Configuration();
		
		cfg=cfg.configure("cfg/hibernate.cfg.xml");
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Student s1=ses.load(Student.class, 1);
		
		s1.setStudentStream("ETC");
		s1.setStudentPercentage(75.25);
		
		tx=ses.beginTransaction();
		
		ses.update(s1);
		
		tx.commit();
		
		System.out.println("Student details are updated succesfully");
		
	}

}
