package com.example.Authentication.controllers;

import java.util.Optional;
import java.util.logging.LogManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Authentication.entities.User;
import com.example.Authentication.exceptions.UserNotFoundException;
import com.example.Authentication.repositories.UserRepository;
import com.example.Authentication.services.UserService;

@Controller
public class LoginController {
	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final UserService userService;
	
	LoginController(UserRepository repository, UserService userService) {
		this.userRepository = repository;
		this.userService = userService;
	}

    @GetMapping("/")
    public String showGreeting(ModelMap map) {
        return "index";
    }


    @GetMapping("/login")
    public String showLogin(ModelMap map) {
        return "login";
    }
    
    @GetMapping("/logout")
    public String showLogout(ModelMap map) {
    	map.addAttribute("successMessage", "Logout Success!");
        return "index";
    }

    @PostMapping("/login")
    public String submitLogin(@RequestParam String username, @RequestParam String password, Model model){
    	User foundUser = userService.GetUserByUsername(username);
    	if (foundUser == null || !(foundUser.getUsername().equals(username) && foundUser.getPassword().equals(password))) {
    		model.addAttribute("errorMessage", "Username/Password combination not found!");
    		return "index";
    	} else {
    		
    	}
    	return "dashboard";
    }
}
