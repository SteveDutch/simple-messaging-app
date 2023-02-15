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
		System.out.println("im controller erhaltener user: "+ user);
		User actualUser = userService.findExactlyOneUserByUsername(user.getUsername());
		System.out.println("aus DB retournierter User:  " + actualUser);
		userService.saveUser(actualUser);
		System.out.println("im Controller gespeicherter user: " + actualUser);
		return "/welcome";
	}
	
//	@PostMapping("/welcome")
//	public String postUsername (@RequestBody String username, String userId) {
//		System.out.println(username + "here");
//		
//		//userService.saveUser(user);
//		return "/welcome";
//	}

}