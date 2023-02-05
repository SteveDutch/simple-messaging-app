package com.stevedutch.assignment14.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class Message {
	
	private String messageText;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
	private Long messageId;
    
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String message) {
		this.messageText = message;
	}
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	@Override
	public String toString() {
		return "Message [messageText=" + messageText + ", messageId=" + messageId + "]";
	}

}
