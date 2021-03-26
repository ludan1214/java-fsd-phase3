package com.example.servingwebcontent;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/search")
	public String searchId(
			@RequestParam(name="id", required=false, defaultValue="-1") String id, Model model) {
		Optional<User> user = userService.GetUserById(id);
		
		if (!user.isPresent()) {
			model.addAttribute("errorMessage", "User Not Found");
			return "index";
		} else {
			User foundUser = user.get();
			model.addAttribute("user", foundUser);
			return "search";
		}
		
	}
}
