package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Query;

import java.util.*;

public class Console {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		do {
			SessionFactory Factory = new Configuration()
					// Reads all connection configuration
					.configure("hibernate.cfg.xml")
					// Read our mapping
					.addAnnotatedClass(Task.class).buildSessionFactory();

			Session sess = Factory.getCurrentSession();

			try {

				sess.beginTransaction();

				System.out.println("Welcome to our Task Maker Hibernate Mini Project!!!");
				System.out.println("PLEASE CHOOSE ONE OF THE FOLLOWING: ");
				System.out.println("Enter 1 to CREATE  A TASK");
				System.out.println("Enter 2 to FIND TASK");
				System.out.println("Enter 3 to UPDATE A TASK");
				System.out.println("Enter 4 to DELETE A TASK");

				int option = sc.nextInt();

				switch (option) {

				case 1:
					create(sess, null, null, null, null);
					break;
				case 2:
					find(sess, null);
					break;
				case 3:
					update(sess, null, null);
					break;

				case 4:
					delete(sess, null, null);
					break;

				}

				sess.getTransaction().commit();

			} catch (Exception ex) {

				ex.printStackTrace();
				Factory.close();
				sc.close();
			}
			System.out.println("Enter 1 to CONTINUE or 2 to EXIT ");
			choice = sc.nextInt();
		}

		while ((choice == 1));

		System.out.println("Thank you for using our Task Maker Hibernate Mini Project!!!");
		System.out.println("Have a Good day!!");

	}

	// METHODS HERE
	// CREATE

	public static void create(Session session, String task, String desc, String em, String un) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter your USER NAME: ");
			un = sc.nextLine();

			System.out.println("Enter you EMAIL: ");
			em = sc.nextLine();

			System.out.println("Enter TASK NAME: ");
			task = sc.nextLine();

			System.out.println("Enter TASK DESRCIPTION: ");
			desc = sc.nextLine();

			Task tsk = new Task(task, desc, em, un);

			session.save(tsk);

			System.out.println("Task Has been created successfully");
		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	// FIND

	public static void find(Session sess, String em) {

		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("PLEASE ENTER YOUR EMAIL TO FIND TASK: ");
			em = sc.nextLine();

			String query = "from Task where email like  :kw";
			List<Task> tsk = sess.createQuery(query).setParameter("kw", "%" + em + "%").getResultList();

			// printing
			for (int i = 0; i < tsk.size(); i++) {

				System.out.println(tsk.get(i).toString());
			}
		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}

	// UPDATE

	public static void update(Session sess, String email, String task_name) {
		Scanner sc = new Scanner(System.in);
		try {
			String query = "from Task where email=:email AND task_name=:task_name";
			System.out.println("PLEASE ENTER YOUR EMAIL TO UPDATE TASK: ");
			email = sc.nextLine();

			System.out.println("PLEASE ENTER TASK NAME TO BE UPDATED: ");
			task_name = sc.nextLine();

			System.out.println("PLEASE ENTER NEW VALUE OF THE TASK: ");
			String nv = sc.nextLine();

			List<Task> newTask = sess.createQuery(query).setParameter("email", email)
					.setParameter("task_name", task_name).getResultList();

			// printing
			for (int i = 0; i < newTask.size(); i++) {

				System.out.println(newTask.get(i).toString());
				newTask.get(i).setTask_name(nv);

				System.out.println("TASK HAS BEEN SUCCESSFULLY UPDATED: ");
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	// DELETE

	public static void delete(Session sess, String email, String task_name) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("PLEASE ENTER YOUR EMAIL TO DELETE TASK: ");
			email = sc.nextLine();

			System.out.println("PLEASE ENTER TASK NAME TO BE DELETED: ");
			task_name = sc.nextLine();

			String query = "delete from Task where email=:email AND task_name=:task_name";

			sess.createQuery(query).setParameter("email", email).setParameter("task_name", task_name).executeUpdate();

			System.out.println("TASK HAS BEEN SUCCESSFULLY DELETED: ");
			
		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}

}
