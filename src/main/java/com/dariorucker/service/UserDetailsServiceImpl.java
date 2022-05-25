package com.dariorucker.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dariorucker.entity.Role;
import com.dariorucker.repository.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		
		com.dariorucker.entity.User appUser = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Invalid username."));
		
		Set <GrantedAuthority> grantList = new HashSet<GrantedAuthority> ();
		for(Role role : appUser.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDescription());
			grantList.add(grantedAuthority);
		}
		
		UserDetails userDetails = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
		
		
		return userDetails;
	}

}
