package com.stevedutch.assignment14.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
// XXX removed GSON, because "Mixing both libs can make make debugging harder in case of issues"
//import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "messages")
public class Message {

//	@SerializedName("messageText")
	private String messageText;

//	@SerializedName("messageId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id")
	private Long messageId;

	@JsonBackReference
//	@SerializedName("user")
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Message() {

	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Message [messageText = " + messageText + ", messageId = " + messageId 
				+ ", user = " + (user.getUsername()) + (user.getUserId()) + "]";
	}

}
