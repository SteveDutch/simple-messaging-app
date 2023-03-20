package com.stevedutch.assignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stevedutch.assignment14.domain.User;
import com.stevedutch.assignment14.service.UserService;

@Controller
public class UserController {
	
    @Autowired
    private UserService userService;

	@GetMapping("/welcome")
	public String welcomeUser(ModelMap model) {
		model.put("user", model);
		return "/welcome";
	}
	
	@PostMapping("/welcome")
	public String postUser (@RequestBody User user) {
		User actualUser = userService.findExactlyOneUserByUsername(user.getUsername());
		userService.saveUser(actualUser);
		return "/welcome";
	}
	
}