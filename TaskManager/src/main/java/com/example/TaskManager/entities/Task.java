package com.example.TaskManager.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task_tbl")
public class Task {

	
	@Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private Integer id;
	   private String name;
	   private Date startDate;
	   private Date endDate;
	   private String severity;
	   private String description;
	   private String email;
	   
	   @ManyToOne
	   @JoinColumn(name="user_id", nullable=false)
	   private TaskUser user;
	   
	public Task() {}
	   
	public Task(String name, Date startDate, Date endDate, String severity, String description, String email,
			TaskUser user) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.severity = severity;
		this.description = description;
		this.email = email;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getSeverity() {
		return severity;
	}


	public void setSeverity(String severity) {
		this.severity = severity;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public TaskUser getUser() {
		return user;
	}


	public void setUser(TaskUser user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return 
		"id: " + id +		
		"\nName: " + name +
		"\nUser: " + user +
		"\nEmail: " + email +
		"\nSeverity: " + severity +
		"\nStart Date: " + startDate +
		"\nEnd Date: "+ endDate +
		"\nDescription:" + description;
	}
	
	
}
