package entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="LabTwo")
public class empLabTwo {
	
	
	@Id
	@Column(name="empId")
	int id;
	
	@Column(name="firstName")
	String firstName;
	
	@Column(name="lastName")
	String lastName;
	
	@Column(name="email")
	String email;
	
	public empLabTwo() {
		
	}
	
	public empLabTwo(String fn, String ln, String em) {
		this.setFirstName(fn);
		this.setLastName(ln);
		this.setEmail(em);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String printLabTwo(){

		return"ID: "+id+" FirstName: "+firstName+ " LastName: " +lastName +" Email: "+ email; 

		}
	

	

}
