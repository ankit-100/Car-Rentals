package com.project.rentals.onlineCarRentals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.rentals.onlineCarRentals.entity.User;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * RESTful API controller for handling user-related requests.
 */
@CrossOrigin(origins="http://localhost:3000/")
@Slf4j
@RestController
@RequestMapping("/api/User")
public class UserController {

	@Autowired
	private UserService us;

	public void setUs(UserService us) {
		this.us = us;
	}

	/**
	 * Inserts a new user.
	 *
	 * @param u The user to insert.
	 * @return The inserted user.
	 * @throws AlreadyPresentException If the user already exists.
	 */
	@PostMapping("/insert")
	public User insert(@RequestBody User u) throws AlreadyPresentException {
		log.info("Insert into table: {}", u);
		return us.insert(u);
	}

	/**
	 * Retrieves a user by their ID.
	 *
	 * @param userId The ID of the user to retrieve.
	 * @return The retrieved user.
	 * @throws NotFoundException If the user is not found.
	 */
	@GetMapping("/userId/{userId}")
	public User findByUserId(@PathVariable int userId) throws NotFoundException {
		log.info("Find by userId: {}", userId);
		return us.findByUserId(userId);
	}
	
	/**
	 * Retrieves a user by their Email.
	 *
	 * @param email The ID of the user to retrieve.
	 * @return The retrieved user.
	 * @throws NotFoundException If the user is not found.
	 */
	@GetMapping("/email/{email}")
	public User findByEmail(@PathVariable String email) throws NotFoundException{
		log.info("Find by email: {}", email);
		return us.findByEmail(email);
	}

	/**
	 * Deletes a user by their ID.
	 *
	 * @param userId The ID of the user to delete.
	 * @return A success message upon successful deletion.
	 * @throws NotFoundException If the user is not found.
	 */
	@DeleteMapping("/{userId}")
	public String deleteByUserId(@PathVariable int userId) throws NotFoundException {
		log.info("Delete by userId: {}", userId);
		return us.delete(userId);
	}

	/**
	 * Updates a user by their ID.
	 *
	 * @param userId The ID of the user to update.
	 * @param user   The updated user object.
	 * @return A success message upon successful update.
	 * @throws NotFoundException If the user is not found.
	 */
	@PutMapping("/update/{userId}")
	public String update(@PathVariable int userId, @RequestBody User user) throws NotFoundException {
		log.info("Update table by userId: {}", userId, user);
		String result = us.update(userId, user);
		return result;
	}

	/**
	 * Retrieves all users.
	 *
	 * @return The list of all users.
	 */
	@GetMapping("/all")
	public List<User> getAll() {
		log.info("Get all data: {}");
		return us.getAll();
	}
}
