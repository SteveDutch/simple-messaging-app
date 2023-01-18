package com.stevedutch.assignment14.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/welcome")
	public String welcomeUser(ModelMap model) {

		model.put("user", model);
		return "/welcome";
	}

}