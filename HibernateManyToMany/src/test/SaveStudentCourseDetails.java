package test;

//PROGRAM TO SAVE STUDENT AND COURSE DETAILS 
//AND MULTIPLE COURSES FOR SINGLE STUDENT

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

public class SaveStudentCourseDetails {

	public static void main(String[] args) {
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
        cfg = new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Course.class);
		
		factory =cfg.buildSessionFactory();
		ses=factory.openSession();
		
		//create object of student
		
		Student s1=new Student();
		s1.setStudentName("Rahul");
		s1.setStudentEmail("rh@gmail.com");
		
		//create object of course class
		
		Course c1=new Course();
		c1.setCourseName("JAVA");
		c1.setCourseCode("JV001");
		
		Course c2=new Course();
		c2.setCourseName("J2EE");
		c2.setCourseCode("JV002");
		
		
        //ADD COURSES FOR STUDENT
		s1.addCourses(c1);
		s1.addCourses(c2);
		
		//Transaction
		
		tx=ses.beginTransaction();
		ses.save(s1);
		ses.save(c1);
		ses.save(c2);
		
		tx.commit();
		
		System.out.println("Student detail inserted succesfully");
		
	}

}
