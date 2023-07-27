package com.project.rentals.onlineCarRentals.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.rentals.onlineCarRentals.entity.Parking;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.repository.ParkingRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Service implementation for managing parking-related operations.
 */
@Slf4j
@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	private ParkingRepository pr;

	/**
	 * Inserts a new parking entry into the system.
	 *
	 * @param p The parking entry to be inserted.
	 * @return The inserted parking entry.
	 * @throws AlreadyPresentException If the parking entry already exists in the
	 *                                 system.
	 */
	@Override
	public Parking insert(Parking p) throws AlreadyPresentException {
		log.info("Insert into parking table: {}", p);
		if (pr.existsById(p.getParkingNo())) {
			throw new AlreadyPresentException();
		}
		return pr.save(p);
	}

	/**
	 * Retrieves a parking entry by its parking ID.
	 *
	 * @param parkingNo The parking ID to retrieve the parking entry.
	 * @return The retrieved parking entry.
	 * @throws NotFoundException If the parking entry with the given ID is not
	 *                           found.
	 */
	@Override
	public Parking findByParkingId(int parkingNo) throws NotFoundException {
		log.info("Find by parkingId: {}", parkingNo);
		Parking parking;
		if (pr.findById(parkingNo).isEmpty()) {
			throw new NotFoundException();
		} else {
			parking = pr.findById(parkingNo).get();
		}
		return parking;
	}

	/**
	 * Deletes a parking entry from the system.
	 *
	 * @param parkingNo The parking ID of the entry to delete.
	 * @return A message indicating the success or failure of the deletion
	 *         operation.
	 * @throws NotFoundException If the parking entry with the given ID is not
	 *                           found.
	 */
	@Override
	public String delete(int parkingNo) throws NotFoundException {
		log.info("Delete by parkingNo : {}", parkingNo);
		if (pr.findById(parkingNo).isEmpty()) {
			throw new NotFoundException();
		}
		pr.deleteById(parkingNo);
		return "Delete Successful ";
	}

	/**
	 * Updates the details of a parking entry.
	 *
	 * @param parkingNo The parking ID of the entry to update.
	 * @param parking   The updated parking entry.
	 * @return A message indicating the success or failure of the update operation.
	 * @throws NotFoundException If the parking entry with the given ID is not
	 *                           found.
	 */
	@Override
	public String update(int parkingNo, Parking parking) throws NotFoundException {
		log.info("Update by parkingNo: {}", parkingNo, parking);
		if (pr.findById(parkingNo).isEmpty()) {
			throw new NotFoundException();
		} else
			pr.save(parking);
		return "Update Successful";

	}

	/**
	 * Retrieves a list of all parking entries in the system.
	 *
	 * @return A list of all parking entries.
	 */
	@Override
	public List<Parking> getAll() {
		log.info("Get all data: {}");
		return pr.findAll();
	}
}
