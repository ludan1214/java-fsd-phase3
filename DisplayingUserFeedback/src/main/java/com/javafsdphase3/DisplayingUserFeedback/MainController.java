package com.javafsdphase3.DisplayingUserFeedback;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	 @GetMapping(value="/")
     public String showIndexPage(ModelMap model, 
    		 @RequestParam(value="username", required=false) String username,
     		 @RequestParam(value="message", required=false) String message){
	     model.addAttribute("name", username);    
	     model.addAttribute("message", message);  
		 return "index";
     }
}