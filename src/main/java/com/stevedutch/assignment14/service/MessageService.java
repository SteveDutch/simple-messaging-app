package com.stevedutch.assignment14.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stevedutch.assignment14.domain.Message;
import com.stevedutch.assignment14.domain.User;
import com.stevedutch.assignment14.dto.MessageTextAndUserDTO;
import com.stevedutch.assignment14.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepo;
	
	public Message saveMessage(Message message) {
		return messageRepo.save(message);
		
	}

	public Message saveMessage(String string, User user) {
		System.out.println(string + " (from start of MessageService.saveMessage()");
		Message message = new Message();
		message.setUser(user);
		message.setMessageText(string);
		System.out.println(message);
		return messageRepo.save(message);
		
	}

	public ArrayList<Message> findLast10Messages() {
		return messageRepo.findLast10Messages();
		
	}
	
	public ArrayList<MessageTextAndUserDTO> get10MessagesDTO() {
		List <Message> lastTen = messageRepo.findLast10Messages();
		ArrayList<MessageTextAndUserDTO> messageDTO = new ArrayList<>();

		for (Message elem : lastTen) {
		    MessageTextAndUserDTO messDTO = new MessageTextAndUserDTO();
		    messDTO.setMessageText(elem.getMessageText());
		    messDTO.setUsername(elem.getUser().getUsername());
		    messageDTO.add(messDTO);
		}
		
		Collections.reverse(messageDTO); 
		return messageDTO ;
	}

	public ArrayList<Message> findLast10MessageTextsAndUsermame() {
		System.out.println(messageRepo.findLast10MessageTextsAndUsermame());
		return messageRepo.findLast10MessageTextsAndUsermame();
	}

}
