package com.project.rentals.onlineCarRentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.rentals.onlineCarRentals.entity.User;

/**
 * Repository interface for accessing and manipulating user data in the
 * database.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

}
