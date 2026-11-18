package org.emsi.service_voiture;

import org.emsi.service_voiture.Entity.Car;
import org.emsi.service_voiture.Entity.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient  // Active l'enregistrement auprès d'Eureka
public class CarApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserBaseH2(CarRepository voitureRepository) {
        return args -> {
            // (id, brand, model, matricule, client_id)
            voitureRepository.save(new Car(null, "Toyota",  "Corolla", "A 25 333",  1L));
            voitureRepository.save(new Car(null, "Renault", "Megane",  "B 6 3456",  1L));
            voitureRepository.save(new Car(null, "Peugeot", "301",     "A 55 4444", 2L));

            voitureRepository.findAll().forEach(System.out::println);
        };
    }
    /**
     * Configure RestTemplate pour la communication inter-services
     * @return Instance configurée de RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        // Configuration des timeouts
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);  // 5 secondes pour la connexion
        requestFactory.setReadTimeout(5000);     // 5 secondes pour la lecture

        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }
}