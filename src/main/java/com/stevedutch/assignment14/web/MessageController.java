package com.stevedutch.assignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stevedutch.assignment14.domain.Message;
import com.stevedutch.assignment14.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping("channel")
	public void postMessage(@RequestBody String string) {
		System.out.println("hooray! submit butto or enter has been hit! " + string + " was entered");
		messageService.saveMessage(string);
		
		return;
	}

}
