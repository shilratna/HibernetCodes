package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Employee;

public class SaveEmployee {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter employee id");
		int id=scan.nextInt();
		
		System.out.println("Enter employee name ");
		String name = scan.next();
		
		System.out.println("Enter employee salary");
		double salary=scan.nextDouble();
		
		Configuration cfg=null;
		SessionFactory factory= null;
		Session ses= null;
		Transaction tx= null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfg/hibernate.cfg.xml");
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//create an object of employee class 
		Employee e1=new Employee(id, name, salary);
				
	    tx=ses.beginTransaction();
		
		ses.save(e1);
		
		tx.commit();
		
		System.out.println("Employee inserted succesfully");
		scan.close();

	}

}
