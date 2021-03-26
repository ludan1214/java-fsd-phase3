package com.example.TaskManager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Task doesnt exists") //404
public class TaskNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public TaskNotFoundException(String ex) {
		super("TaskNotFoundException: " + ex);
	}
}

