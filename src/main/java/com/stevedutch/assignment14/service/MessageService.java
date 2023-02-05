package com.stevedutch.assignment14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stevedutch.assignment14.domain.Message;
import com.stevedutch.assignment14.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepo;

	public Message saveMessage(Message message) {
		return messageRepo.save(message);
		
	}

	public Message saveMessage(String string) {
		System.out.println(string + " (from start of MessageService.saveMessage()");
		Message message = new Message();
		message.setMessageText(string);
		System.out.println(message);
		return messageRepo.save(message);
		
	}

}
