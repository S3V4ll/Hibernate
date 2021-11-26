package entity;

import java.util.List;


import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class empApp {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(empLabTwo.class)
								.buildSessionFactory();
	
		Session sess= factory.getCurrentSession();
		
		try {
	

			// START
			sess.beginTransaction();
			
			
			
			
			// CREATE 
//						empApp.create(sess,"Uno","First","1@gmail.com");
//						empApp.create(sess,"Dos","Second","2@gmail.com");
//						empApp.create(sess,"Tres","Third","3@gmail.com");
//						empApp.create(sess,"Quatro","Fourth","4@gmail.com");
//						
//						System.out.println("SUCCESSFULLY UPLOADED TO DATABASE!!!" );

			
			
			//RETRIEVE USING PK 
//						empApp.retrievePk(sess, 4);
			
			
			//DELETE USING PK
			
//						empApp.deletePk(sess, 8);
			//QUERY
						empApp.getUsingFNLN(sess, "Uno", "First");
						
			// End or commit transaction
			sess.getTransaction().commit();
						 
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			factory.close();
			
		}

	}
	
		//CREATE RECORD
		public static void  create(Session session,String fn,String ln,String em) {
			
			empLabTwo methodObj = new  empLabTwo(fn,ln,em);
		   session.save(methodObj);
			
		}
		
		// RETRIEVE USING PK
		public static void retrievePk(Session session , int pk) {
			
			empLabTwo methodObj = session.get(empLabTwo.class,pk);
		    
			System.out.println(methodObj.printLabTwo());
			
			
		}
		
		// UPDATE  LastName
		
		public static void updateLN(Session session ,int pk ,String newValue) {
			
			empLabTwo methodObj = session.get(empLabTwo.class,pk);
			
			methodObj.setLastName(newValue);
			
			
		}
		
		// Delete Record
		
		public static void deletePk(Session session,int pk) {
			
			empLabTwo methodObj = session.get(empLabTwo.class,pk);
			session.delete(methodObj);
		   
			
		}
		
		//QUERY WITH LAST OR FIRST NAME 
		
				public static void getUsingFNLN(Session sess, String fn, String ln) {
					
					String query = "from empLabTwo where firstName=:fsname OR lastName=:lsname";
					List<empLabTwo> emp = sess
												.createQuery(query)
												.setParameter("fsname", fn)
												.setParameter("lsname", ln)
												.getResultList();
				
					//printing
					 for(int i=0; i<emp.size();i++) {
						 
						 System.out.println(emp.get(i).printLabTwo());
					 }
		
		
			
			
		

	}
}