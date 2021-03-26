package com.example.TaskManager.controllers;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.TaskUser;
import com.example.TaskManager.exceptions.TaskAlreadyExistsException;
import com.example.TaskManager.exceptions.UserNotFoundException;
import com.example.TaskManager.services.TaskService;
import com.example.TaskManager.services.UserService;

@Controller
public class TaskController {
	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
	private final TaskService taskService;
	
	@Autowired
	private final UserService userService;
	
	TaskController(TaskService taskService, UserService userService) {
		this.taskService = taskService;
		this.userService = userService;
	}
	
	@PostMapping("/addTask")
    public String submitTask(
    		@RequestParam String name, 
    		@RequestParam String startDate, 
    		@RequestParam String endDate,
    		@RequestParam String severity, 
    		@RequestParam String description, 
    		@RequestParam String email,
    		Model model, HttpServletRequest request){
		// First, check if task already exists
		if (taskService.GetTaskByName(name) != null) {
			throw new TaskAlreadyExistsException(name);
		}
		
		// Process name parameter
		Principal principal = request.getUserPrincipal();
		String username = principal.getName();
		
		//Process Date parameters
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date start = null, end = null;
		try {
			start = format.parse(startDate);
			end = format.parse(endDate);
		} catch (Exception e) {
			logger.error(e.toString());
		}
    	TaskUser foundUser = userService.GetUserByUsername(username);
    	if (foundUser == null) {
    		logger.debug("User not Found: " + username);
    		throw new UserNotFoundException(username);
    	} else {
    		Task task = new Task(name, start, end, severity, description, email, foundUser);
    		taskService.UpdateTask(task);
    		logger.info("User: " + username + " Posted a new task :\n" + task);
    		model.addAttribute("successMessage", "New Task Posted!");
    	}
    	return "createTask";
    }
	
	@ExceptionHandler(TaskAlreadyExistsException.class) 
	public ModelAndView handleUserAlreadyExistsException(HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("errorMessage", "Task name already exists, please enter a different name");
	    modelAndView.setViewName("createTask");
	    return modelAndView;
	}
	
	@ExceptionHandler(UserNotFoundException.class) 
	public ModelAndView handleUserNotFoundException(HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("errorMessage", "Invalid Login Session, please login!");
	    modelAndView.setViewName("login");
	    return modelAndView;
	}
}
