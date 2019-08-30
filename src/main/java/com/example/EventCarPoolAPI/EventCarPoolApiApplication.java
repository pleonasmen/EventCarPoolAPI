package com.example.EventCarPoolAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EventCarPoolApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventCarPoolApiApplication.class, args);
	}
}
