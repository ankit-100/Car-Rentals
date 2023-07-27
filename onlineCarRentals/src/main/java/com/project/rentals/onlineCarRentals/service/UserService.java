package com.project.rentals.onlineCarRentals.service;

import java.util.List;

import com.project.rentals.onlineCarRentals.entity.User;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;

/**
 * Service interface for managing user-related operations.
 */
public interface UserService {
	/* Inserts a new user into the system. */
	public User insert(User u) throws AlreadyPresentException;

	/* Retrieves a user by its user ID. */
	public User findByUserId(int userId) throws NotFoundException;

	/* Retrieves a user by its email ID. */
	public User findByEmail(String email) throws NotFoundException;
 
	/* Deletes a user from the system. */
	public String delete(int userId) throws NotFoundException;

	/* Updates the details of a user. */
	public String update(int userId, User user) throws NotFoundException;

	/* Retrieves a list of all user in the system. */
	public List<User> getAll();
}
