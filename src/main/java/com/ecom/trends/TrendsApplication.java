package com.ecom.trends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class TrendsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrendsApplication.class, args);
        System.out.println("Server Running...");
	}
}