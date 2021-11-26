package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.*;

@Entity
@Table(name="Donner")
public class Donner {
	
	@Id                        
	@Column(name="id")
	private int id;
	
	@Column(name="Donner_name ")
	private String Donner_name ;
	
	@Column(name="Donner_blood_group")
	private String Donner_blood_group;
	
	@Column(name="Donner_date_of_birth")
	private String Donner_date_of_birth;
	
	@Column(name="Donner_age")
	private String Donner_age;
	
	@Column(name="Create dated")
	private String CreateDated;
	
	public Donner() {

	}

	public Donner(String donner_name, String donner_blood_group, String donner_date_of_birth, String donner_age,
			String createDated) {
		
		Donner_name = donner_name;
		Donner_blood_group = donner_blood_group;
		Donner_date_of_birth = donner_date_of_birth;
		Donner_age = donner_age;
		CreateDated = createDated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDonner_name() {
		return Donner_name;
	}

	public void setDonner_name(String donner_name) {
		Donner_name = donner_name;
	}

	public String getDonner_blood_group() {
		return Donner_blood_group;
	}

	public void setDonner_blood_group(String donner_blood_group) {
		Donner_blood_group = donner_blood_group;
	}

	public String getDonner_date_of_birth() {
		return Donner_date_of_birth;
	}

	public void setDonner_date_of_birth(String donner_date_of_birth) {
		Donner_date_of_birth = donner_date_of_birth;
	}

	public String getDonner_age() {
		return Donner_age;
	}

	public void setDonner_age(String donner_age) {
		Donner_age = donner_age;
	}

	public String getCreateDated() {
		return CreateDated;
	}

	public void setCreateDated(String createDated) {
		CreateDated = createDated;
	}

	@Override
	public String toString() {
		return "Donner [id=" + id + ", Donner_name=" + Donner_name + ", Donner_blood_group=" + Donner_blood_group
				+ ", Donner_date_of_birth=" + Donner_date_of_birth + ", Donner_age=" + Donner_age + ", CreateDated="
				+ CreateDated + "]";
	}
	
	
	
	
	

}

