package com.project.rentals.onlineCarRentals.service;

import java.util.List;

import com.project.rentals.onlineCarRentals.entity.Parking;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;

/**
 * Service interface for managing parking-related operations.
 */
public interface ParkingService {
	/* Inserts a new parking into the system. */
	public Parking insert(Parking p) throws AlreadyPresentException;

	/* Retrieves a parking by its parking No. */
	public Parking findByParkingId(int parkingNo) throws NotFoundException;

	/* Deletes a parking from the system. */
	public String delete(int parkingNo) throws NotFoundException;

	/* Updates the details of a parking. */
	public String update(int parkingNo, Parking parking) throws NotFoundException;

	/* Retrieves a list of all parking in the system. */
	public List<Parking> getAll();
}
