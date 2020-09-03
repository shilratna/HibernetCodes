package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Passport;
import domain.Person;

public class SaveDetails 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the person name :");
		String name=scan.next();
		
		System.out.println("Enter person age");
	    int age=scan.nextInt();
	    
	    System.out.println("Enter the passport number");
	    String passno=scan.next();
	    
	    System.out.println("Enter the name of country");
	    String country=scan.next();
	    
	    
	    Configuration cfg=null;
	    SessionFactory factory=null;
	    Session ses=null;
	    Transaction tx=null;
	    
	    
	    
	    cfg=new Configuration();
	    
	    
	    cfg=cfg.configure("cfgs/hibernate.cfg.xml");
	    cfg=cfg.addAnnotatedClass(Passport.class);
	    cfg=cfg.addAnnotatedClass(Person.class);
	    
	    factory=cfg.buildSessionFactory();
	    
	    ses=factory.openSession();
	    
	    //Create object of passport class
	    
	    Passport passObj= new Passport();
	    passObj.setPassportNo(passno);
	    passObj.setCountryName(country);
	    
	    
	    //create object of person class
	    
	    Person perObj= new Person();
	    perObj.setPersonName(name);
	    perObj.setPersonAge(age);
	    
	    //Association passport object with person object
	    perObj.setPassRef(passObj); //call by ref Variable
	    
	    tx=ses.beginTransaction();
	    
	    ses.save(perObj);
	    
	    tx.commit();
	    
	    System.out.println("Person detail inserted Succesfully");
	    
	    
	}

}
