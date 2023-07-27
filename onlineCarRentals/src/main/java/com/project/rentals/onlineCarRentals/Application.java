package com.project.rentals.onlineCarRentals;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

	/* The main entry point of the application. */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	/* This method is executed after the application context is loaded. */
	@Override
	public void run(String... args) throws Exception {

		log.info("Application Started");
	}

}
