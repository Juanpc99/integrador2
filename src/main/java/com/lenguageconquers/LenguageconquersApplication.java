package com.lenguageconquers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class LenguageconquersApplication {

	public static void main(String[] args) {

		System.setProperty("spring.devtools.restart.enabled", "false");

		SpringApplication.run(LenguageconquersApplication.class, args);
	}

}
