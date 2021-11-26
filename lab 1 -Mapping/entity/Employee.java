package entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;



@Entity
@Table(name="Employee")
public class Employee {
	
	
	@Id
	@Column(name="empID")
	int empID;
	
	@Column(name="firstname")
	String firstName;
	
	@Column(name="lastname")
	String lastName;
	
	@Column(name="email")
	String email;
	
	@Column(name="salary")
	int salary;
	
	
	public Employee () {
		
	}
	
	public Employee (String fn, String ln, String em, int sal) {

		this.setFirstName(fn);    
	      this.setLastName(ln);       
	      this.setEmail(em);           
	      this.setSalary(sal);           
		
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
	
	
	
}
