package entity;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class SessionAndFactory {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
	
		Session sess= factory.getCurrentSession();
		
		try {
	
			System.out.println("CREATING OBJECT OF STUDENT......");
			
			Employee em = new Employee("VALL","SILAO","Lab1@gmail.com", 25000);
	
		
			sess.beginTransaction();
			 
			sess.save(em);
		
			sess.getTransaction().commit();
			
			System.out.println("LAB 1 DATA STORED TO DATABASE SUCCESSFULLY!!");
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			factory.close();
		}

		
	}
}
