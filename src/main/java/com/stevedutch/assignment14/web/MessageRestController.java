package com.stevedutch.assignment14.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stevedutch.assignment14.dto.MessageTextAndUserDTO;
import com.stevedutch.assignment14.service.MessageService;

@RestController
public class MessageRestController {
	
	@Autowired
	MessageService messageService;
	
	@GetMapping("/channel/messages")
	public String getLast10Messages () throws JsonProcessingException {
//		ArrayList<Message> messagesToJS = messageService.findLast10Messages();
		System.out.println("very start of RestController, ");
// XXX this doesn't looks good
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<MessageTextAndUserDTO> messagesToJsDTO = messageService.get10MessagesDTO();
		String resultDTO = mapper.writeValueAsString(messagesToJsDTO);
		

		System.out.println("resultDTO = " + resultDTO);
		return resultDTO;
		
	}

}
