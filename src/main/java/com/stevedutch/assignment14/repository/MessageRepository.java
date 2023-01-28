package com.stevedutch.assignment14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stevedutch.assignment14.domain.User;

public interface MessageRepository extends JpaRepository <User, Long>{

}
