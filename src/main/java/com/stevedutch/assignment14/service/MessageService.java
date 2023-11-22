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

	public void saveMessage(Message message) {
		messageRepo.save(message);
	}

	public ArrayList<MessageTextAndUserDTO> get10MessagesDTO() {
		List<Message> lastTen = messageRepo.findTop10ByOrderByIdDesc();
		ArrayList<MessageTextAndUserDTO> messageDTO = new ArrayList<>();

		for (Message elem : lastTen) {
			MessageTextAndUserDTO messDTO = new MessageTextAndUserDTO();
			messDTO.setMessageText(elem.getMessageText());
			messDTO.setUsername(elem.getUser().getUsername());
			messageDTO.add(messDTO);
		}

		Collections.reverse(messageDTO);
		return messageDTO;
	}
}
