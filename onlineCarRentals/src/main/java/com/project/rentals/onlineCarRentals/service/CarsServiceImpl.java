package com.project.rentals.onlineCarRentals.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.rentals.onlineCarRentals.entity.Cars;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.repository.CarsRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Service implementation for managing car-related operations.
 */
@Slf4j
@Service
public class CarsServiceImpl implements CarsService {

	@Autowired
	private CarsRepository cr;

	/**
	 * Inserts a new car into the system.
	 *
	 * @param c The car to be inserted.
	 * @return The inserted car.
	 * @throws AlreadyPresentException If the car already exists in the system.
	 */
	@Override
	public Cars insert(Cars c) throws AlreadyPresentException {
		log.info("Insert into cars: {}", c);
		if (cr.existsById(c.getCarId())) {
			throw new AlreadyPresentException();
		}

		return cr.save(c);
	}

	/**
	 * Retrieves a car by its car ID.
	 *
	 * @param carId The ID of the car to retrieve.
	 * @return The retrieved car.
	 * @throws NotFoundException If the car with the given ID is not found.
	 */
	@Override
	public Cars findByCarId(int carId) throws NotFoundException {
		log.info("Find by carId: {}", carId);
		Cars cars;
		if (cr.findById(carId).isEmpty()) {
			throw new NotFoundException();
		} else {
			cars = cr.findById(carId).get();
		}
		return cars;
	}

	/**
	 * Deletes a car from the system.
	 *
	 * @param carId The ID of the car to delete.
	 * @return A message indicating the success or failure of the deletion
	 *         operation.
	 * @throws NotFoundException If the car with the given ID is not found.
	 */
	@Override
	public String delete(int carId) throws NotFoundException {
		log.info("Delete by carId: {}", carId);
		if (cr.findById(carId).isEmpty()) {
			throw new NotFoundException();
		}
		cr.deleteById(carId);
		return "Delete Successful";
	}

	/**
	 * Updates the details of a car.
	 *
	 * @param carId The ID of the car to update.
	 * @param cars  The updated car object.
	 * @return A message indicating the success or failure of the update operation.
	 * @throws NotFoundException If the car with the given ID is not found.
	 */
	@Override
	public String update(int carId, Cars cars) throws NotFoundException {
		log.info("Update table by carId: {}", carId, cars);
		if (cr.findById(carId).isEmpty()) {
			throw new NotFoundException();
		} else {
			cr.save(cars);
		}
		return "Update Successful";
	}

	/**
	 * Retrieves a list of all cars in the system.
	 *
	 * @return A list of all cars.
	 */
	@Override
	public List<Cars> getAll() {
		log.info("Get all data: {}");
		return cr.findAll();
	}
}
