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

	public User saveUser(String username) {
		System.out.println(username);
		User user = userRepo.findByUsername(username);
		if (user == null) {
			user = new User();
			user.setUsername(username);
			return userRepo.save(user);
		} else {
			return user;
		}

	}

	public User findExactlyOneUserByUsername(String username) {
		List<User> users = userRepo.findExactlyOneUserByUsername(username);
		if (users.size() > 0) {
			System.out.println("existierenden user gefuden!");
			return users.get(0);
		} else
			System.out.println("neuer user kreiert");
		return new User(username);
	}

	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	public User findByUsername(User user) {
		return userRepo.findByUsername(user.username);
	}

}
