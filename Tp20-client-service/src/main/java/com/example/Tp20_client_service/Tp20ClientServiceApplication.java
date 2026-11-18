package com.example.Tp20_client_service;

import com.example.Tp20_client_service.entities.Client;
import com.example.Tp20_client_service.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class Tp20ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp20ClientServiceApplication.class, args);
	}
	@Bean
    CommandLineRunner initialiserBaseDeDonnees(ClientRepository clientRepository) {
		return args -> {
			clientRepository.save(new Client(null, "Amal", 22f));
			clientRepository.save(new Client(null, "Youssef", 25f));
			clientRepository.save(new Client(null, "Salma", 30f));

			// Vérification dans la console
			clientRepository.findAll().forEach(System.out::println);
		};
}
}
