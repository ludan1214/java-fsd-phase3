package com.example.TaskManager.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.TaskManager.exceptions.UserNotFoundException;

@Controller
public class LoginRegistrationErrorController {
	private static final Logger logger = LoggerFactory.getLogger(LoginRegistrationErrorController.class);
	
	@GetMapping("/loginError")
    public void showLoginError(ModelMap map) {
		logger.error("Failed login attempt");
		throw new UserNotFoundException();
    }
	
	@ExceptionHandler(UserNotFoundException.class) 
	public ModelAndView handleUserNotFoundException(HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("errorMessage", "Username/Password combination not found!");
	    modelAndView.setViewName("login");
	    return modelAndView;
	}
    
}
