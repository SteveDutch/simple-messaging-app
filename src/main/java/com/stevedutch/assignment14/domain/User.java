package com.stevedutch.assignment14.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
//XXX removed GSON, because "Mixing both libs can make make debugging harder in case of issues"
// import com.google.gson.annotations.SerializedName;

@Entity // Class name = User, DB Table name = user
@Table(name = "users") // changed into users
public class User {

	@Column(unique = true)
	public String username;

//	@SerializedName("userId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonManagedReference
	@OneToMany(mappedBy = "user")
	private List<Message> messages = new ArrayList<>();

	public User(String username, List<Message> messages) {
		this.username = username;
		this.messages = messages;
	}

	public User(String username) {
		this.username = username;
	}

	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", userId=" + id + "messages: " + messages + "]";
	}

}
