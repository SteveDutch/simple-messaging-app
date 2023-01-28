package com.stevedutch.assignment14.service;

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

	public User saveUser(String username) {
		System.out.println(username);
		User user = new User();
		user.setUsername(username);
		System.out.println(user);
		return userRepo.save(user);
		
	}

}
