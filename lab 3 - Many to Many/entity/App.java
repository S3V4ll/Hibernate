package entity;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Task.class)
				.addAnnotatedClass(Teacher.class).buildSessionFactory();

		Session sess = factory.getCurrentSession();

		try {

			System.out.println("Welcome to many to many app!");
			sess.beginTransaction();

			// INPUT DATA
			App.InsertValues(sess);

			sess.getTransaction().commit();

			System.out.println("INPUT SUCCESSFULLY DONE !!!");
			System.out.println("Thank you ! Have a good day!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// methods

	// Create Employee
	public static void InsertValues(Session sess) {
		Scanner sc = new Scanner(System.in);
		try {

			Task p = new Task();
			System.out.println("Please enter value of TASK");
			String desc = sc.nextLine();

			p.setDescription(desc);

			HashSet<Task> descriptions = new HashSet<>();
			descriptions.add(p);

			Teacher teacher = new Teacher();
			System.out.println("Please enter FIRST NAME");
			String fName = sc.nextLine();

			teacher.setFirst_name(fName);

			System.out.println("Please enter LAST NAME");
			String lName = sc.nextLine();

			teacher.setLast_name(lName);
			teacher.setDescriptions(descriptions);

			sess.save(teacher);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}