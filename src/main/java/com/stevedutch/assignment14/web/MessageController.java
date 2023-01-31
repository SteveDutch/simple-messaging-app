package com.stevedutch.assignment14.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MessageController {
	
	@PostMapping("channel")
	public void postMessage(@RequestBody String string) {
		System.out.println("hooray! submit butto or enter has been hit! " + string + " was entered");
		Boolean result = true;
		return;
	}

}
