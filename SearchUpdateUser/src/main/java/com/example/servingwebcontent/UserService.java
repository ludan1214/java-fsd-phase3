package com.example.servingwebcontent;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	 private UserRepository userRepository;
	
	

    public Iterable<User> GetAllUsers()
    {
        return userRepository.findAll();
    }


    public User GetUserByName(String firstname) {
        User foundUser = userRepository.findByFirstname(firstname);
        return foundUser;
    }
    
    public Optional<User> GetUserById(String id) {
    	Optional<User> foundUser = userRepository.findById(Long.parseLong(id));
    	
    	return(foundUser);
    }
    
    public void UpdateUser(User usertoUpdate) {
    	userRepository.save(usertoUpdate);
    }


}
