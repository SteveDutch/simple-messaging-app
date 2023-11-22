package com.stevedutch.assignment14.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stevedutch.assignment14.domain.Message;
import com.stevedutch.assignment14.domain.User;
import com.stevedutch.assignment14.dto.MessageTextAndUserDTO;
import com.stevedutch.assignment14.service.MessageService;
import com.stevedutch.assignment14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@JsonIgnoreProperties(value = {"userId"})
@RestController
public class MessageController {
	
    @Autowired
    private UserService userService;
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping("channel")
	public void postMessageInclUser(@RequestBody Message message) {

		System.out.println(message);
		
		User user = userService.findByUsername(message.getUser());
		message.setUser(user);
		messageService.saveMessage(message);
	}

	@GetMapping("/channel/messages")
	public List<MessageTextAndUserDTO> getLast10Messages () {

		System.out.println("very start of RestController, ");

		return messageService.get10MessagesDTO();
	}
}
