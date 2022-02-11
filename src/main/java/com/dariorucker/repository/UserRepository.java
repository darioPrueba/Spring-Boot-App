package com.dariorucker.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dariorucker.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	
}
