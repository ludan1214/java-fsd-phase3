package com.javafsdphase3.DisplayingUserFeedback;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Feedback {
	private @Id @GeneratedValue Long id;
	private String username;
	private String message;
	
	Feedback() {}
	
	Feedback(String username, String message) {
		this.username = username;
		this.message = message;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "id: " + this.id + " User: " + this.username + " Feedback: " + this.message;
	}
}
