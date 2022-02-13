package com.dariorucker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dariorucker.entity.User;
import com.dariorucker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public Iterable<User> getAllUsers() {
			
		return repository.findAll();
	}
	
	private boolean checkUsernameAvailable(User user) throws Exception {
		Optional<User> userFound = repository.findByUsername(user.getUsername());
		if(userFound.isPresent()) {
			throw new Exception("Username exists");
		}
		return true;
	}
	
	private boolean checkPasswordValid(User user) throws Exception {

		if(user.getConfirmPassword()== null || user.getConfirmPassword().isEmpty()){
			throw new Exception("Confirm Password cant be empty");
		}
		if(!user.getPassword().equals(user.getConfirmPassword())){
			throw new Exception("Password and Confirm Password are different");
		}
		return true;
	}

	@Override
	public User createUser(User user) throws Exception {
		
		if(checkUsernameAvailable(user) && checkPasswordValid(user)) {
			user = repository.save(user);
		}
		
		return user;
	}

	@Override
	public User getUserById(Long id) throws Exception {

		return repository.findById(id).orElseThrow(() -> new Exception("The user does not exist"))   ;
	}

	@Override
	public User updateUser(User fromUser) throws Exception {

		User toUser = repository.findById(fromUser.getId()).get();
		mapUser(fromUser, toUser);
		return repository.save(toUser);
	}
	/**
	 * Map everything but the password.
	 * @param from
	 * @param to
	 */
	
	
	protected void mapUser(User from, User to) {
		to.setUsername(from.getUsername());
		to.setFirstName(from.getFirstName());
		to.setLastName(from.getLastName());
		to.setEmail(from.getEmail());
		to.setRoles(from.getRoles());
	}
	
	
}
