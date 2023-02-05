package com.stevedutch.assignment14.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stevedutch.assignment14.domain.Message;

public interface MessageRepository extends JpaRepository <Message, Long>{

	// Message save(String string);

	

}
 