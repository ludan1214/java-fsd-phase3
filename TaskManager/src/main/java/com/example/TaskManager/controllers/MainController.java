package com.example.TaskManager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	
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
    


}