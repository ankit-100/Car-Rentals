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

import com.project.rentals.onlineCarRentals.entity.Cars;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.service.CarsService;

import lombok.extern.slf4j.Slf4j;

/**
 * RESTful API controller for handling car-related requests.
 */
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/Cars")
public class CarsController {

	@Autowired
	private CarsService cs;

	public void setCs(CarsService cs) {
		this.cs = cs;
	}

	/**
	 * Inserts a new car.
	 *
	 * @param c The car to insert.
	 * @return The inserted car.
	 * @throws AlreadyPresentException If the car already exists.
	 */
	@PostMapping("/insert")
	public Cars insert(@RequestBody Cars c) throws AlreadyPresentException {
		log.info("Insert into cars: {}", c);
		return cs.insert(c);

	}

	/**
	 * Retrieves a car by its ID.
	 *
	 * @param carId The ID of the car to retrieve.
	 * @return The retrieved car.
	 * @throws NotFoundException If the car is not found.
	 */
	@GetMapping("/{carId}")
	public Cars findByCarId(@PathVariable int carId) throws NotFoundException {
		log.info("Find by carId: {}", carId);
		return cs.findByCarId(carId);
	}

	/**
	 * Deletes a car by its ID.
	 *
	 * @param carId The ID of the car to delete.
	 * @return A success message upon successful deletion.
	 * @throws NotFoundException If the car is not found.
	 */
	@DeleteMapping("/{carId}")
	public String deleteByCarId(@PathVariable int carId) throws NotFoundException {
		log.info("Delete by carId: {}", carId);
		return cs.delete(carId);
	}

	/**
	 * Updates a car by its ID.
	 *
	 * @param carId The ID of the car to update.
	 * @param cars  The updated car object.
	 * @return A success message upon successful update.
	 * @throws NotFoundException If the car is not found.
	 */
	@PutMapping("/update/{carId}")
	public String update(@PathVariable int carId, @RequestBody Cars cars) throws NotFoundException {
		log.info("Update table by carId: {}", carId, cars);
		return cs.update(carId, cars);
	}

	/**
	 * Retrieves all cars.
	 *
	 * @return The list of all cars.
	 */
	@GetMapping("/all")
	public List<Cars> getAll() {
		log.info("Get all data: {}");
		return cs.getAll();
	}
}
