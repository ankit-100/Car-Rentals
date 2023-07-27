package com.project.rentals.onlineCarRentals.exception;

@SuppressWarnings("serial")
public class AlreadyPresentException extends Exception {

	private String message;

	/**
	 * Default constructor for AlreadyPresentException.
	 */
	public AlreadyPresentException() {
	}

	/**
	 * Constructor for AlreadyPresentException with a custom message.
	 *
	 * @param message The custom message.
	 */
	public AlreadyPresentException(String message) {
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
