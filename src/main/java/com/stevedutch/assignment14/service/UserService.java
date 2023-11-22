package com.stevedutch.assignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stevedutch.assignment14.domain.User;
import com.stevedutch.assignment14.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public User findExactlyOneUserByUsername(String username) {
		
		User user = userRepo.findExactlyOneUserByUsername(username);
		if (user != null) {
			System.out.println("existierenden user gefuden!");
			return user;
		} else
			System.out.println("neuer user kreiert");
		return new User(username);
	}

	public User findByUsername(User user) {
		return userRepo.findByUsername(user.username);
	}
}
