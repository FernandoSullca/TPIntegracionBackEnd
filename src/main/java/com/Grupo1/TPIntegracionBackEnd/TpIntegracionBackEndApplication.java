package com.Grupo1.TPIntegracionBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.Grupo1.TPIntegracionBackEnd")
//@ComponentScan(basePackages = "com.Grupo1.TPIntegracionBackEnd")
//@EntityScan(basePackages = "com.Grupo1.TPIntegracionBackEnd")
public class TpIntegracionBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpIntegracionBackEndApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
			}
		};
	}
}
