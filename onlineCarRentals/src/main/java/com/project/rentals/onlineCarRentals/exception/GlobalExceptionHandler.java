package com.project.rentals.onlineCarRentals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * Global exception handler for handling NotFoundException.
	 * 
	 * @param nfe The NotFoundException object.
	 * 
	 * @return ResponseEntity with the appropriate message and HTTP status.
	 */
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<String> NotFoundException(NotFoundException nfe) {
		log.info("NotFound: {}");
		String message1 = nfe.getMessage();
		if (message1 == null || message1.isEmpty()) {
			message1 = "Not Found! ";
		}
		return new ResponseEntity<String>(message1, HttpStatus.NOT_FOUND);
	}

	/*
	 * Global exception handler for handling AlreadyPresentException.
	 * 
	 * @param ape The AlreadyPresentException object.
	 * 
	 * @return ResponseEntity with the appropriate message and HTTP status.
	 */
	@ExceptionHandler(value = AlreadyPresentException.class)
	public ResponseEntity<String> AlreadyPresentException(AlreadyPresentException ape) {
		log.info("Already Present: {}");
		String message2 = ape.getMessage();
		if (message2 == null || message2.isEmpty()) {
			message2 = "Already Present! ";

		}
		return new ResponseEntity<String>(message2, HttpStatus.CONFLICT);
	}
}
