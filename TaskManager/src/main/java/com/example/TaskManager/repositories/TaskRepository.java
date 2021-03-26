package com.example.TaskManager.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.TaskUser;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Integer> {

    public List<Task> findAllByUser(TaskUser user);
    
    public Task findByName(String name);
    
    public int deleteTaskByName(String name);
}
