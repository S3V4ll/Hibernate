package entity;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DonnerApp {

	public static void main(String[] args) {
		
		SessionFactory Factory = new Configuration() 
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Donner.class)
				                 .buildSessionFactory();
	
		Session sess = Factory.getCurrentSession();
		
		try {
			
		
			sess.beginTransaction();
			
			// CREATE 
			DonnerApp.create(sess, "abel", "Type A", "02/22/1985", "35", "09/22/2021");
			
			
			// DELETE INSTRUCTOR
			
			DonnerApp.delete(sess, 1);
			

			sess.getTransaction().commit();
			 
			 
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}finally {
			
			Factory.close();
		}
		
	
				              	

	}

	
	// CREATE
	
	
	public static void  create(Session session,String name,String bg,String dob,String age, String date) {
		
	   Donner donObj = new Donner(name,bg,dob,age,date);
	   session.save(donObj);
		
	}
	
	// DELETE
	
	public static void delete(Session session,int pk) {
		
		Donner donObj = session.get(Donner.class,pk);
		session.delete(donObj);
	}

		 
	 }	
		



