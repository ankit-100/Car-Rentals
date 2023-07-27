package com.project.rentals.carRentals.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.rentals.onlineCarRentals.controller.ParkingController;
import com.project.rentals.onlineCarRentals.entity.Parking;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.service.ParkingService;

public class ParkingControllerTest {

	@Mock
	ParkingService ps;
	@InjectMocks
	ParkingController pc;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test for the insert() method in ParkingController.
	 */
	@Test
	public void testInsert() throws AlreadyPresentException {

		ParkingService ps = Mockito.mock(ParkingService.class);
		ParkingController pc = new ParkingController();
		pc.setPs(ps);
		Parking p = new Parking();
		Mockito.when(ps.insert(Mockito.any(Parking.class))).thenReturn(p);
		Parking result = pc.insert(p);
		assertNotNull(result);
	}

	/**
	 * Test for the findByParkingId() method in ParkingController.
	 */
	@Test
	public void testFindById() throws NotFoundException {
		ParkingService ps = Mockito.mock(ParkingService.class);
		ParkingController pc = new ParkingController();
		pc.setPs(ps);
		int parkingNo = 1;
		Mockito.when(ps.findByParkingId(parkingNo)).thenReturn(new Parking());
		Parking result = pc.findByParkingId(parkingNo);
		assertNotNull(result);
	}

	/**
	 * Test for the deleteByParkingId() method in ParkingController.
	 */
	@Test
	public void testDeleteById() throws NotFoundException {
		ParkingService ps = Mockito.mock(ParkingService.class);
		ParkingController pc = new ParkingController();
		pc.setPs(ps);
		int parkingNo = 1;
		Mockito.when(ps.delete(parkingNo)).thenReturn("Deleted");
		String result = pc.deleteByParkingId(parkingNo);
		assertEquals("Deleted", result);
	}

	/**
	 * Test for the update() method in ParkingController.
	 */
	@Test
	public void testUpdate() throws NotFoundException {
		ParkingService ps = Mockito.mock(ParkingService.class);
		ParkingController pc = new ParkingController();
		pc.setPs(ps);
		int parkingNo = 1;
		Parking p = new Parking();
		Mockito.when(ps.update(parkingNo, p)).thenReturn("Updated");
		String result = pc.update(parkingNo, p);
		assertEquals("Updated", result);
	}

	/**
	 * Test for the getAll() method in ParkingController.
	 */
	@Test
	public void testGetAllParkingTables() {
		ParkingService ps = Mockito.mock(ParkingService.class);
		ParkingController pc = new ParkingController();
		pc.setPs(ps);
		List<Parking> p = new ArrayList<>();
		Mockito.when(ps.getAll()).thenReturn(p);
		List<Parking> result = pc.getAll();
		assertNotNull(result);
	}

}
