package org.emsi.tp19_GateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
@SpringBootApplication
public class Tp20GateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp20GateWayApplication.class, args);
	}
	@Bean
	public DiscoveryClientRouteDefinitionLocator routesDynamic(
			ReactiveDiscoveryClient reactiveDiscoveryClient,
			DiscoveryLocatorProperties discoveryLocatorProperties) {
		return new DiscoveryClientRouteDefinitionLocator(
				reactiveDiscoveryClient,
				discoveryLocatorProperties
		);
	}
}
