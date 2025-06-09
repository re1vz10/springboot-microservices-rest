package com.example.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
@CrossOrigin
public class GatewayServiceApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("admissions-service", r -> r.path("/api/admissions/**")
                .uri("lb://admissions-service"))
            .route("doctor-service", r -> r.path("/api/doctor/**")
                .uri("lb://doctor-service"))
            .route("patient-service", r -> r.path("/api/patients/**")
                .uri("lb://patient-service"))
            .route("provincenames-service", r -> r.path("/api/province_names/**")
                .uri("lb://provincenames-service"))
            .build();
    }
	
//	@Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:4200") // Angular frontend
//                .allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(), HttpMethod.DELETE.name(), HttpMethod.OPTIONS.name())
//                .allowedHeaders("*")
//                .allowCredentials(true)
//                .exposedHeaders("Authorization");
//    }

}
