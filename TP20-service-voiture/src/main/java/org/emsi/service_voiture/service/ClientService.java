package org.emsi.service_voiture.service;
import org.emsi.service_voiture.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="TP19-SERVICE-CLIENT")
public interface ClientService{
    @GetMapping(path="/clients/{id}")
    Client clientById(@PathVariable Long id);
}