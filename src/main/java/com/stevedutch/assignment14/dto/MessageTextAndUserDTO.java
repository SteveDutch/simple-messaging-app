package com.stevedutch.assignment14.dto;

public class MessageTextAndUserDTO {

	private String messageText;
	private String username;

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "MessageTextAndUserDTO [messageText = " + messageText + " , username = " + username + "]";
	}

}
