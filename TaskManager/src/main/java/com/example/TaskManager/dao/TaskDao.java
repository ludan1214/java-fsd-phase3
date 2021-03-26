package com.example.TaskManager.dao;

import java.util.List;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.TaskUser;

public interface TaskDao {
	
	List<Task> getTasksByUser(TaskUser user);
	public Task getTaskByName(String name);
	void saveTask(Task task);
	void deleteTask(Task task);
}
