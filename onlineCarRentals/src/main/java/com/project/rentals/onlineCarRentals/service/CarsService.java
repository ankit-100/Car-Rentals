package com.project.rentals.onlineCarRentals.service;

import java.util.List;

import com.project.rentals.onlineCarRentals.entity.Cars;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;

/**
 * Service interface for managing car-related operations.
 */
public interface CarsService {

	/* Inserts a new car into the system. */
	public Cars insert(Cars c) throws AlreadyPresentException;

	/* Retrieves a car by its car ID. */
	public Cars findByCarId(int carId) throws NotFoundException;

	/* Deletes a car from the system. */
	public String delete(int carId) throws NotFoundException;

	/* Updates the details of a car. */
	public String update(int carId, Cars cars) throws NotFoundException;

	/* Retrieves a list of all cars in the system. */
	public List<Cars> getAll();
}
