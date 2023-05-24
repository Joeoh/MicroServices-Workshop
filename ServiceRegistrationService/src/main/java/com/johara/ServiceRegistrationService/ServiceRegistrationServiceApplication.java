package com.johara.ServiceRegistrationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistrationServiceApplication {

	public static void main(String[] args) {

		System.setProperty("spring.config.name", "registration-server");
		SpringApplication.run(ServiceRegistrationServiceApplication.class, args);
	}

}
