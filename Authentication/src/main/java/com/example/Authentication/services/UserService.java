package com.example.Authentication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.Authentication.entities.User;
import com.example.Authentication.exceptions.UserNotFoundException;
import com.example.Authentication.repositories.UserRepository;



@Service()
@Qualifier("UserService")
public class UserService {
	@Autowired
	private UserRepository userRepository;
    
    public void setUserRepository(UserRepository repository) {
    	this.userRepository = repository;
    }
    
    public User GetUserByUsername(String username) {
    	Iterable<User> users = userRepository.findAll();
    	for (User user : users) {
    		if (user.getUsername().equals(username)) {
    			return user;
    		}
    	}
        return null;
    }
    
    public User GetUserByPassword(String password) {
    	Iterable<User> users = userRepository.findAll();
    	for (User user : users) {
    		if (user.getPassword().equals(password)) {
    			return user;
    		}
    	}
        return null;
    }
    
    public User GetUserById(int id) {
    	Optional<User> foundUser = userRepository.findById(id);
    	
    	
    	//TODO: we need to decide how to handle a "Not Found" condition
    	
    	if (!foundUser.isPresent()) {
    		throw new UserNotFoundException();
    	}
    	
    	return(foundUser.get());
    }
    
    public void UpdateUser(User usertoUpdate) {
    	userRepository.save(usertoUpdate);
    }


}
