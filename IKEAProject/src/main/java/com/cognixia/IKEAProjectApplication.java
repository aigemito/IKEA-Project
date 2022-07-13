package com.cognixia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@SpringBootApplication

public class IKEAProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IKEAProjectApplication.class, args);
	}

}
