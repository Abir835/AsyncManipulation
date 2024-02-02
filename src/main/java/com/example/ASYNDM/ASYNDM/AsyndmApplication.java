package com.example.ASYNDM.ASYNDM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AsyndmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyndmApplication.class, args);
	}

}
