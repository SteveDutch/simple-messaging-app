package com.stevedutch.assignment14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stevedutch.assignment14.domain.Message;

public interface MessageRepository extends JpaRepository <Message, Long> {

//	 XXX To use native SQL queries with Spring Data JPA, you need to add the nativeQuery parameter 
//	 to the @Query annotation and set it to true.
	@Query(value = "SELECT * FROM messages ORDER BY message_id DESC LIMIT 10", nativeQuery = true)
	public ArrayList<Message> findLast10Messages();
	
	// XXX this is not working - wegen circular references in User & Message I Think
//	@Query(value = "SELECT messages.message_text, users.username FROM messages JOIN users ON messages.user_id = users.user_id GROUP BY messages.message_text, users.username ORDER BY MAX(messages.message_id) DESC LIMIT 10" , nativeQuery = true)
//	@Query(value = "SELECT MAX(messages.message_id) AS message_id, messages.message_text, users.username FROM messages JOIN users ON messages.user_id = users.user_id GROUP BY messages.message_text, users.username ORDER BY message_id DESC LIMIT 10", nativeQuery = true)
	@Query(value ="SELECT messages.message_text, users.username FROM messages JOIN users ON messages.user_id = users.user_id GROUP BY messages.message_id ORDER BY messages.message_id DESC LIMIT 10", nativeQuery = true)
	public ArrayList<Message> findLast10MessageTextsAndUsermame();

	public List<Message> findByMessageId(Long messageId);
	


}