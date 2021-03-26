package com.example.TaskManager.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.TaskUser;
import com.example.TaskManager.exceptions.TaskNotFoundException;
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
	
	public void deleteTaskById(Integer id) {
		repository.deleteById(id);
	}
	
	public Task GetTaskById(Integer id) {
		Optional<Task> foundTask = repository.findById(id);
		if (!foundTask.isPresent()) {
			throw new TaskNotFoundException(id.toString());
		}
		return foundTask.get();
	}
	
	public Task GetTaskByName(String name) {
		return repository.findByName(name);
	}
	
	public Task UpdateTask(Task taskToUpdate) {
		return repository.save(taskToUpdate);
	}
	
	public int deleteTaskByName(String name) {
		return repository.deleteTaskByName(name);
	}
}
