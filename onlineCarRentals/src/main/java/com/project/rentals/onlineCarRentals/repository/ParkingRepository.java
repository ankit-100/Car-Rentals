package com.project.rentals.onlineCarRentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.rentals.onlineCarRentals.entity.Parking;

/**
 * Repository interface for accessing and manipulating parking data in the
 * database.
 */
@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {

}
