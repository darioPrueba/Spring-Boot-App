package com.dariorucker.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class Passgenerator {


public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		System.out.println(bCryptPasswordEncoder.encode("1234"));
		
	}

}
