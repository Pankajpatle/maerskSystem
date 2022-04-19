package com.maersk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MaerskSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaerskSystemApplication.class, args);
	}

	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
