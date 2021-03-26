package com.example.TaskManager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Task already exists") //404
public class TaskAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public TaskAlreadyExistsException(String name) {
		super("TaskAlreadyExistsException with name="+name);
	}
}
