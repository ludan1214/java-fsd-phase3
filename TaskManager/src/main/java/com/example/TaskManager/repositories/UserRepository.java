package com.example.TaskManager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskManager.entities.TaskUser;

@Repository
public interface UserRepository extends JpaRepository<TaskUser, Integer> {

    public Optional<TaskUser> findByUsername(String username);
}