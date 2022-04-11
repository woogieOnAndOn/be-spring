package com.auth.woogie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BeSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(BeSpringApplication.class, args);
	}

}
