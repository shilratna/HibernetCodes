package test;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import domain.Passport;
import domain.Person;


public class DisplayPersonDetails {

	public static void main(String[] args) {
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg= new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Passport.class);
		cfg=cfg.addAnnotatedClass(Person.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Person p=ses.load(Person.class, 1);
		
		System.out.println(p.getPersonName());
		System.out.println(p.getPersonAge());
		System.out.println(p.get);
		
		
		

	}

}
