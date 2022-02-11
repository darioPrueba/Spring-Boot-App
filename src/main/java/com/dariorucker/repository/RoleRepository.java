package com.dariorucker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dariorucker.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
