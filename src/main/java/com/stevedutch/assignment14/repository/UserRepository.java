package com.stevedutch.assignment14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stevedutch.assignment14.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	// select * from users where username = :username
//	List<User> findByUsername2(String username);
	
	// select * from users where username = :username
	public User findByUsername(String username);


	@Query("select u from User u where username = :username")
	public List<User> findExactlyOneUserByUsername(String username);

}
