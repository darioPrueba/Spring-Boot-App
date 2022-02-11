package com.dariorucker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/userform")
	public String userForm(){
		return "user-form";
	}
}
//Login-with-SpringBoot/src/main/resources/templates/user-form/user-view.html