package com.example.TaskManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.TaskManager.entities.TaskUser;
import com.example.TaskManager.repositories.UserRepository;

@Service
public class TaskManagerUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<TaskUser> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(username);
        } else {
        	TaskUser founduser = user.get();
        	UserDetails details = User
        			.withUsername(founduser.getUsername())
        			.password(founduser.getPassword())
        			.authorities("USER")
        			.build();
        	return details;   	
        }
    }
}