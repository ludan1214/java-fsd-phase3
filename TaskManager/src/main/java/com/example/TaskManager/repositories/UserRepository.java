package com.example.TaskManager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManager.entities.TaskUser;

public interface UserRepository extends JpaRepository<TaskUser, Integer> {

    public Optional<TaskUser> findByUsername(String username);
}