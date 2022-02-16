package com.dariorucker.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.dariorucker.dto.ChangePasswordForm;
import com.dariorucker.entity.User;

@Service
public interface UserService {

	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;
	
	public User getUserById(Long id) throws Exception;
	
	public User updateUser(User formUser) throws Exception;
	
	public void deleteUser(Long id) throws Exception;
	
	public User changePassword(ChangePasswordForm form) throws Exception;
}
