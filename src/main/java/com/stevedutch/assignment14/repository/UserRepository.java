package com.stevedutch.assignment14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stevedutch.assignment14.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// XXX wiederhole warum dies funktioniert ohne @Query --> weil es Teil von JpaRepository ist :)
	User findByUsername(String username);

	@Query("select u from User u where username = :username")
	User findExactlyOneUserByUsername(String username);

}
