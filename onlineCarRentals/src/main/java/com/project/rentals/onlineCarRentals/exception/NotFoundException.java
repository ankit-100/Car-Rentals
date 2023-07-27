package com.project.rentals.onlineCarRentals.exception;

@SuppressWarnings("serial")
public class NotFoundException extends Exception {

	private String message;

	/**
	 * Default constructor for NotFoundException.
	 */
	public NotFoundException() {
	}

	/**
	 * Constructor for NotFoundException with a custom message.
	 *
	 * @param message The custom message.
	 */
	public NotFoundException(String message) {
		this.message = message;
	}

	/**
	 * Get the message associated with the exception.
	 *
	 * @return The exception message.
	 */
	public String getMessage() {
		return this.message;
	}
}
