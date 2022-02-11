package com.dariorucker.service;

import org.springframework.stereotype.Service;

import com.dariorucker.entity.User;

@Service
public interface UserService {

	public Iterable<User> getAllUsers();
	
}
