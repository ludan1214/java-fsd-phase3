package com.example.TaskManager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.TaskUser;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    public List<Task> findAllByUser(TaskUser user);
    
    public Task findByName(String name);
}
