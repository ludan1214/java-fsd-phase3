package com.example.TaskManager.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.TaskUser;
import com.example.TaskManager.repositories.TaskRepository;

@Service()
@Qualifier("TaskService")
public class TaskService {
	private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
	
	@Autowired
	private TaskRepository repository;
	
	public List<Task> GetAllTasks() {
		
		return repository.findAll();
	}
	
	public List<Task> GetTasksByUser(TaskUser user) {
		List<Task> result = repository.findAllByUser(user);
		if(result.isEmpty()) {
			logger.debug("Empty Task Search result for user: " + user);
			return null;
		} else {
			return result;
		}
	}
	
	public Task GetTaskByName(String name) {
		return repository.findByName(name);
	}
	
	public Task UpdateTask(Task taskToUpdate) {
		return repository.save(taskToUpdate);
	}
}
