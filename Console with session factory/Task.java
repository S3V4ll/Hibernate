package entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "task_name")
	private String task_name;

	@Column(name = "task_description")
	private String task_description;

	@Column(name = "email")
	private String email;

	@Column(name = "user_name")
	private String user_name;

	public Task() {

	}

	public Task(String task_name, String task_description, String email, String user_name) {

		this.task_name = task_name;
		this.task_description = task_description;
		this.email = email;
		this.user_name = user_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getTask_description() {
		return task_description;
	}

	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", task_name=" + task_name + ", task_description=" + task_description + ", email="
				+ email + ", user_name=" + user_name + "]";
	}

}
