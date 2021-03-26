package com.example.TaskManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.TaskUser;
import com.example.TaskManager.repositories.UserRepository;



@Service()
@Qualifier("UserService")
public class UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
    
    public void setUserRepository(UserRepository repository) {
    	this.userRepository = repository;
    }
    
    public TaskUser GetUserByUsername(String username) {
    	Optional<TaskUser> foundUser = userRepository.findByUsername(username);
    	if (!foundUser.isPresent()) {
    		return null;
    	}
    	return(foundUser.get());
    }
    
    public TaskUser GetUserByPassword(String password) {
    	Iterable<TaskUser> taskUsers = userRepository.findAll();
    	for (TaskUser taskUser : taskUsers) {
    		if (taskUser.getPassword().equals(password)) {
    			return taskUser;
    		}
    	}
        return null;
    }
    
    public TaskUser GetUserById(int id) {
    	Optional<TaskUser> foundUser = userRepository.findById(id);
    	
    	
    	//TODO: we need to decide how to handle a "Not Found" condition
    	
    	if (!foundUser.isPresent()) {
    		return null;
    	}
    	
    	return(foundUser.get());
    }
    
    public TaskUser UpdateUser(TaskUser usertoUpdate) {
    	usertoUpdate.setPassword(passwordEncoder.encode(usertoUpdate.getPassword()));
    	return userRepository.save(usertoUpdate);
    }


}
