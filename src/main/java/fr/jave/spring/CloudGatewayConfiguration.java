package fr.jave.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;

@Configuration
public class CloudGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(r -> r.path("/users/**")
                    .uri("http://localhost:5050/")
                    .id("microserviceUsers"))

            .route(r -> r.path("/accounts/**")
                    .uri("http://localhost:5051/")
                    .id("microserviceAccounts"))

            .build();
                
    }
}
