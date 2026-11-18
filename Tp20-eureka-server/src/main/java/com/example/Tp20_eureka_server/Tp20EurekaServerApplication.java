package com.example.Tp20_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer  // Active les fonctionnalités du serveur Eureka

@SpringBootApplication
public class Tp20EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp20EurekaServerApplication.class, args);
	}

}
