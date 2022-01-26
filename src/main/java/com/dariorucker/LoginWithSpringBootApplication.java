package com.dariorucker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class LoginWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginWithSpringBootApplication.class, args);
	}

}
