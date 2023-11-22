package com.stevedutch.assignment14.repository;

import com.stevedutch.assignment14.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository <Message, Long> {

	List<Message> findTop10ByOrderByIdDesc();
}