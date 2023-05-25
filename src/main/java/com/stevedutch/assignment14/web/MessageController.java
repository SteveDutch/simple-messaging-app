package com.stevedutch.assignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stevedutch.assignment14.domain.Message;
import com.stevedutch.assignment14.domain.User;
import com.stevedutch.assignment14.service.MessageService;
import com.stevedutch.assignment14.service.UserService;

@JsonIgnoreProperties(value = {"userId"})
@Controller
public class MessageController {
	
    @Autowired
    private UserService userService;
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping("channel")
	public void postMessageInclUser(@RequestBody Message message) {
		
		User user = userService.findByUsername(message.getUser());
		message.setUser(user); 
		messageService.saveMessage(message);
	}

}
