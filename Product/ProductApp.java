package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductApp {

	public static void main(String[] args) {

		// Create Session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
				.addAnnotatedClass(Product_details.class).buildSessionFactory();

		// Create session

		Session sess = factory.getCurrentSession();

		try {

			sess.beginTransaction();

			// CREATE

			ProductApp.create(sess, null, null);
			
			// UPDATE
			
			ProductApp.update(sess, 0, null);
			
			// DELETE
			
			ProductApp.delete(sess, 0);
			
			
			sess.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// CREATE

	public static void create(Session session, String sku, String pn) {

		Product obj = new Product(sku,pn);
		session.save(obj);

	}

	// UPDATE LastName

	public static void update(Session session, int pk, String newValue) {

		Product obj = session.get(Product.class, pk);

		obj.setProduct_name(newValue);

	}

	// Delete Record

	public static void delete(Session session, int pk) {

		Product obj = session.get(Product.class, pk);
		session.delete(obj);
	}

}
