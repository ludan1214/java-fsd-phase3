package com.example.servingwebcontent;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UpdateController {
	@Autowired
	private UserService userService;
	static Logger log = Logger.getLogger(UpdateController.class.getName());
	
	@GetMapping("/update")
	public String searchId(
			@RequestParam(name="id", required=true) String id,
			@RequestParam(name="username", required=true) String username,
			@RequestParam(name="firstname", required=true) String firstname,
			@RequestParam(name="lastname", required=true) String lastname,
			Model model) {
		Optional<User> user = userService.GetUserById(id);
		if (!user.isPresent()) {
			model.addAttribute("errorMessage", "User Not Found");
		} else {
			User updatedUser = new User();
			updatedUser.setId(Long.parseLong(id));
			updatedUser.setUsername(username);
			updatedUser.setFirstname(firstname);
			updatedUser.setLastname(lastname);
			userService.UpdateUser(updatedUser);
			log.info("Update Successful: " + updatedUser.toString());
			model.addAttribute("updateMessage", "User Updated!");
		}
		return "index";
	}
}