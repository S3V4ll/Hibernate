package entity;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name = "TASK")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private int taskId;

	@Column(name = "description")
	private String description;

	@ManyToMany(mappedBy = "descriptions")
	private Set<Teacher> descriptions = new HashSet<>();

	public Task() {

	}

	public Task(String description) {
		super();
		this.description = description;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Teacher> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<Teacher> descriptions) {
		this.descriptions = descriptions;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", description=" + description + ", descriptions=" + descriptions + "]";
	}

	
}