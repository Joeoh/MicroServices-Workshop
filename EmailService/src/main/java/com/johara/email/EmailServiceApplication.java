package com.johara.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class EmailServiceApplication {

	public static void main(String[] args) {

		System.setProperty("spring.config.name", "email-service");
		SpringApplication.run(EmailServiceApplication.class, args);
	}

}
