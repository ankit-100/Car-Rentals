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

import com.project.rentals.onlineCarRentals.entity.Parking;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.service.ParkingService;

import lombok.extern.slf4j.Slf4j;

/**
 * RESTful API controller for handling parking-related requests.
 */
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/Parking")
public class ParkingController {

	@Autowired
	private ParkingService ps;

	public void setPs(ParkingService ps) {
		this.ps = ps;
	}

	/**
	 * Inserts a new parking record.
	 *
	 * @param p The parking object to insert.
	 * @return The inserted parking object.
	 * @throws AlreadyPresentException If the parking record already exists.
	 */
	@PostMapping("/insert")
	public Parking insert(@RequestBody Parking p) throws AlreadyPresentException {
		log.info("Insert into parking table: {}", p);
		return ps.insert(p);
	}

	/**
	 * Retrieves a parking record by its ID.
	 *
	 * @param parkingNo The ID of the parking record to retrieve.
	 * @return The retrieved parking record.
	 * @throws NotFoundException If the parking record is not found.
	 */
	@GetMapping("/{parkingNo}")
	public Parking findByParkingId(@PathVariable int parkingNo) throws NotFoundException {
		log.info("Find by parkingId: {}", parkingNo);
		return ps.findByParkingId(parkingNo);
	}

	/**
	 * Deletes a parking record by its ID.
	 *
	 * @param parkingNo The ID of the parking record to delete.
	 * @return A success message upon successful deletion.
	 * @throws NotFoundException If the parking record is not found.
	 */
	@DeleteMapping("/{parkingNo}")
	public String deleteByParkingId(@PathVariable int parkingNo) throws NotFoundException {
		log.info("Delete by parkingNo : {}", parkingNo);
		return ps.delete(parkingNo);
	}

	/**
	 * Updates a parking record by its ID.
	 *
	 * @param parkingNo The ID of the parking record to update.
	 * @param parking   The updated parking object.
	 * @return A success message upon successful update.
	 * @throws NotFoundException If the parking record is not found.
	 */
	@PutMapping("/update/{parkingNo}")
	public String update(@PathVariable int parkingNo, @RequestBody Parking parking) throws NotFoundException {
		log.info("Update by parkingNo: {}", parkingNo, parking);
		return ps.update(parkingNo, parking);
	}

	/**
	 * Retrieves all parking records.
	 *
	 * @return The list of all parking records.
	 */
	@GetMapping("/all")
	public List<Parking> getAll() {
		log.info("Get all data: {}");
		return ps.getAll();
	}
}
