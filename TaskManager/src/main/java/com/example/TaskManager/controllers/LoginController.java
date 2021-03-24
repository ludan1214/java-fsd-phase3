package com.example.TaskManager.controllers;

import java.util.Optional;
import java.util.logging.LogManager;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.TaskManager.entities.TaskUser;
import com.example.TaskManager.exceptions.*;
import com.example.TaskManager.repositories.UserRepository;
import com.example.TaskManager.services.UserService;

import ch.qos.logback.classic.Level;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final UserService userService;
	
	LoginController(UserRepository repository, UserService userService) {
		this.userRepository = repository;
		this.userService = userService;
	}
	
	
    @GetMapping("/")
    public String showIndex(ModelMap map) {
        return "index";
    }
    
    @GetMapping("/login")
    public String showLogin(ModelMap map) {
        return "login";
    }
    
    @GetMapping("/register")
    public String showRegister(ModelMap map) {
        return "register";
    }
    
    @GetMapping("/dashboard")
    public String showDashboard(ModelMap map) {
        return "dashboard";
    }
    
    @GetMapping("/logout")
    public String showLogout(ModelMap map) {
    	map.addAttribute("successMessage", "Logout Success!");
        return "index";
    }
    
    @PostMapping("/register")
    public String submitRegister(@RequestParam String username, @RequestParam String password, @RequestParam String email, Model model){
    	TaskUser foundUser = userService.GetUserByUsername(username);
    	if (foundUser != null) {
    		throw new UserAlreadyExistsException(username);
    	} else {
    		TaskUser newUser = new TaskUser(username, email, password);
    		userService.UpdateUser(newUser);
    		logger.info("New User Registered: " + newUser);
    		model.addAttribute("successMessage", "Registration Successful!");
    	}
    	return "index";
    }
    
    @ExceptionHandler(UserAlreadyExistsException.class)
	public ModelAndView handleAlreadyExistException(HttpServletRequest request, Exception ex){
		logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("errorMessage", "Register Failed: User already exists!");
	    modelAndView.setViewName("register");
	    return modelAndView;
	}

}
