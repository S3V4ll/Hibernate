package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class AuthorApp{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		
			SessionFactory Factory = new Configuration()
					// Reads all connection configuration
					.configure("hibernate.cfg.xml")
					// Read our mapping
					.addAnnotatedClass(Author.class).buildSessionFactory();

			Session sess = Factory.getCurrentSession();

			try {

				sess.beginTransaction();

				System.out.println("Welcome to our Author App!!!");
				System.out.println("PLEASE CHOOSE ONE OF THE FOLLOWING: ");
				System.out.println("Enter 1 to CREATE  Author");
				System.out.println("Enter 2 to FIND Author");
				System.out.println("Enter 3 to UPDATE Author");
				System.out.println("Enter 4 to DELETE Author");

				int option = sc.nextInt();

				switch (option) {

				case 1:
					AuthorApp.create(sess, null, option, null, option);
					break;
				case 2:
					AuthorApp.find(sess, null);
					break;
				case 3:
					AuthorApp.update(sess, null);
					break;

				case 4:
					AuthorApp.delete(sess, null);
					break;

				}

				sess.getTransaction().commit();

			} catch (Exception ex) {

				ex.printStackTrace();
				Factory.close();
				sc.close();
			}
			
		

		
	}

	// METHODS HERE
	// CREATE

	public static void create(Session session, String bn, int ap, String aw, int ain) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter BOOK NAME: ");
			bn = sc.nextLine();

			System.out.println("Enter TOTAL PUBLICATION: ");
			ap = sc.nextInt();

			System.out.println("Enter AUTHOR WEBSITE ");
			aw= sc.nextLine();

			System.out.println("IS AUTHOR NEW?: ");
			String ans= sc.nextLine();
			
			
			if(ans=="new") {
			ain=1; 	
			}else{
				ain=0;
			}

			Author details= new Author(bn, ap, aw, ain);

			session.save(details);

			System.out.println("Record created successfully");
		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	// FIND

	public static void find(Session sess, String bn) {

		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("PLEASE ENTER BOOK NAME TO FIND: ");
			bn = sc.nextLine();

			String query = "from Author where Author_book_name like  :kw";
			List<Author> details = sess.createQuery(query).setParameter("kw", "%" + bn + "%").getResultList();
			for (int i = 0; i < details.size(); i++) {

				System.out.println(details.get(i).toString());
			}
		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}

	// UPDATE

	public static void update(Session sess, String bn) {
		Scanner sc = new Scanner(System.in);
		try {
			String query = "from Author where Author_book_name=:Author_book_name";
			System.out.println("PLEASE ENTER BOOK NAME TO UPDATE: ");
			bn = sc.nextLine();

			
			System.out.println("PLEASE ENTER NEW VALUE OF BOOK NAME: ");
			String nv = sc.nextLine();

			List<Author> update = sess.createQuery(query).setParameter("Author_book_name", bn).getResultList();

			// printing
			for (int i = 0; i < update.size(); i++) {

				System.out.println(update.get(i).toString());
				update.get(i).setAuthor_book_name(nv);

				System.out.println("BOOK NAME SUCCESSFULLY UPDATED: ");
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	// DELETE

	public static void delete(Session sess, String bn) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("PLEASE BOOK NAME TO DELETE: ");
			bn= sc.nextLine();

			
			String query = "delete from Author where Author_book_name=:Author_book_name";

			sess.createQuery(query).setParameter("Author_book_name", bn).executeUpdate();

			System.out.println("SUCCESSFULLY DELETED: ");
			
		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}

}
