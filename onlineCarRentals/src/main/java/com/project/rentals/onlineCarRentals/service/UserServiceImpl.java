package com.project.rentals.onlineCarRentals.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.rentals.onlineCarRentals.entity.User;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Service implementation for managing user-related operations.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository ur;

	/**
	 * Inserts a new user into the system.
	 *
	 * @param u The user to be inserted.
	 * @return The inserted user.
	 * @throws AlreadyPresentException If the user ID or email already exists in the
	 *                                 system.
	 */
	@Override
	public User insert(User u) throws AlreadyPresentException {
		log.info("Insert into user table: {}", u);
		if (ur.existsById(u.getUserId())) {
			throw new AlreadyPresentException();
		}
		if (ur.findByEmail(u.getEmail()) != null) {
			throw new AlreadyPresentException();
		}
		return ur.save(u);
	}

	/**
	 * Retrieves a user by their email.
	 *
	 * @param email The email of the user to retrieve.
	 * @return The retrieved user.
	 */
	@Override
	public User findByEmail(String email) throws NotFoundException{

		return ur.findByEmail(email);
	}

	/**
	 * Retrieves a user by their user ID.
	 *
	 * @param userId The user ID to retrieve the user.
	 * @return The retrieved user.
	 * @throws NotFoundException If the user with the given ID is not found.
	 */
	@Override
	public User findByUserId(int userId) throws NotFoundException {
		log.info("Find by userId: {}", userId);
		User user;
		if (ur.findById(userId).isEmpty()) {
			throw new NotFoundException();
		} else {
			user = ur.findById(userId).get();
		}
		return user;
	}

	/**
	 * Deletes a user from the system.
	 *
	 * @param userId The user ID of the user to delete.
	 * @return A message indicating the success or failure of the deletion
	 *         operation.
	 * @throws NotFoundException If the user with the given ID is not found.
	 */
	@Override
	public String delete(int userId) throws NotFoundException {
		log.info("Delete by userId : {}", userId);
		if (ur.findById(userId).isEmpty()) {
			throw new NotFoundException();
		}
		ur.deleteById(userId);
		return "Delete Successful ";
	}

	/**
	 * Updates the details of a user.
	 *
	 * @param userId The user ID of the user to update.
	 * @param user   The updated user.
	 * @return A message indicating the success or failure of the update operation.
	 * @throws NotFoundException If the user with the given ID is not found.
	 */
	@Override
	public String update(int userId, User user) throws NotFoundException {
		log.info("Update by userId: {}", userId, user);
		if (ur.findById(userId).isEmpty()) {
			throw new NotFoundException();
		} else
			ur.save(user);
		return "Update Successful";
	}

	/**
	 * Retrieves a list of all users in the system.
	 *
	 * @return A list of all users.
	 */
	@Override
	public List<User> getAll() {
		log.info("Get all data: {}");
		return ur.findAll();
	}

}
