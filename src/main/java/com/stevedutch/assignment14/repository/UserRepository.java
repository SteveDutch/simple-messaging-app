package com.stevedutch.assignment14.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stevedutch.assignment14.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
