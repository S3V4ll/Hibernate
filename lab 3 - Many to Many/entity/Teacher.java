package entity;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name = "TEACHER")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teacher_id")
	private int teacherID;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "TEACHER_TASK", joinColumns = { @JoinColumn(name = "teacher_id") }, inverseJoinColumns = {
			@JoinColumn(name = "task_id") })
	Set<Task> descriptions = new HashSet<>();

	public Teacher() {

	}

	public Teacher(String first_name, String last_name) {

		this.first_name = first_name;
		this.last_name = last_name;
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Set<Task> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<Task> descriptions) {
		this.descriptions = descriptions;
	}

	@Override
	public String toString() {
		return "Teacher [teacherID=" + teacherID + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", descriptions=" + descriptions + "]";
	}

}