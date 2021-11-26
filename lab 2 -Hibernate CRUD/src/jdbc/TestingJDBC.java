package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestingJDBC{

	public static void main(String[] args) {
		String url="jdbc:mysql://uecfqlcnsw6l82np:0qxm8nmHwwutQuvvuq98@brpoz7mfxwl7bmd6p21x-mysql.services.clever-cloud.com:3306/brpoz7mfxwl7bmd6p21x";
		String user="uecfqlcnsw6l82np";
		String pass="0qxm8nmHwwutQuvvuq98";

		try {
			

			Connection myConn = DriverManager.getConnection(url,user,pass);
 
			
			System.out.println("LAB 1 OUTPUT CONNECTION SUCCESSFUL !!! ");
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
	}

}
