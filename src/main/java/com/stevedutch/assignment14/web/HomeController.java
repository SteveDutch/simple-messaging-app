package com.stevedutch.assignment14.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showHomePage() {
		return "redirect:/welcome";
	}

	@GetMapping("/{page}")
	public String showPage(@PathVariable String page) {
		String redirectUrl;

		// Check if the requested URL is the welcome page
		if (page.equals("welcome")) {
			redirectUrl = "/welcome";
		} else {
			// If the requested URL is not the welcome page, redirect to the welcome page
			redirectUrl = "/welcome";
		}

		return "redirect:" + redirectUrl;
	}

}
