package com.project.rentals.onlineCarRentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.rentals.onlineCarRentals.entity.Cars;

/**
 * Repository interface for accessing and manipulating car data in the database.
 */
@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer> {

}
