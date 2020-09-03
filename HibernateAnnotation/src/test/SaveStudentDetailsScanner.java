package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student;

public class SaveStudentDetailsScanner 
{
	public static void main(String[] args) {
		
	Configuration cfg=null;
	SessionFactory factory=null;
	Session ses=null;
	Transaction tx=null;
	
	cfg=new Configuration();
	
	cfg=cfg.configure("cfgs/hibernate.cfg.xml");
	cfg=cfg.addAnnotatedClass(Student.class);
	
	factory=cfg.buildSessionFactory();
	
	ses=factory.openSession();
	
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the numer Of student info to store:");
	int num=scan.nextInt();
	for(int i=1;i<=num;i++)
	{
	System.out.println("Enter the student id:");
	int id=scan.nextInt();
	System.out.println("Enter the student Name:");
	String name=scan.next();
	System.out.println("Enter the Student Percentage:");
	double perc=scan.nextDouble();
	System.out.println("Enter the student Stream:");
	String stream=scan.next();
	
	Student si = new Student();
	si.setStudentId(id);
	si.setStudentName(name);
	si.setStudentpercentage(perc);
	si.setStudentStream(stream);
	
	tx=ses.beginTransaction();
	
	ses.save(si);
	}
	
	tx.commit();
	
	System.out.println("Student details inserted succesfully");
	
	scan.close();
	}
	

}
