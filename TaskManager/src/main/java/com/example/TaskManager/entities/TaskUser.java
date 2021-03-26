package com.example.TaskManager.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "usertable")
public class TaskUser {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String email;

    private String password;
    
    @OneToMany (mappedBy = "user", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Task> tasks;
    
    public TaskUser() {}
    
    public TaskUser(String username, String email, String password) {
    	this.username = username;
    	this.email = email;
    	this.password = password;
    }
    
    public List<Task> getTasks() {
		return tasks;
	}
    

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Override
    public boolean equals(Object o) {
    	if (o == this) {
    		return true;
    	}
    	
    	if(!(o instanceof Task)) {
    		return false;
    	}
    	
    	Task c = (Task) o;
    	return c.getId() == this.id;
    }
    
    @Override
    public String toString() {
    	return ("Id: " + id.toString() + " Username: " + username + " Email: " + email + " Password: " + password);
    }
    
}