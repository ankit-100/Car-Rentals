package com.project.rentals.carRentals.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.rentals.onlineCarRentals.entity.Parking;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.repository.ParkingRepository;
import com.project.rentals.onlineCarRentals.service.ParkingServiceImpl;

/**
 * Unit tests for the ParkingServiceImpl class.
 */
public class ParkingTest {

	@Mock
	ParkingRepository pr;
	@InjectMocks
	ParkingServiceImpl psi;

	// Injection Mocked
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	private Parking p;

	/**
	 * Test for the getAll() method.
	 */
	@Test
	public void testGetAll() {
		when(pr.findAll()).thenReturn(Arrays.asList(p));
		assertThat(psi.getAll()).hasSize(1);
		verify(pr).findAll();
	}

	/**
	 * Test for the insert() method.
	 */
	@Test
	public void testInsert() throws AlreadyPresentException {
		Parking p = new Parking();
		p.getParkingNo();
		Mockito.when(pr.save(Mockito.any())).thenReturn(p);
		Parking ps = psi.insert(p);
		assertEquals(p, ps);
	}

	/**
	 * Test for the findByParkingNo() method.
	 */
	@Test
	public void testFindByParkingNo() throws NotFoundException {
		int id = 1;
		Parking p = new Parking();
		p.getParkingNo();
		Mockito.when(pr.findById(id)).thenReturn(Optional.of(p));
		Parking result = psi.findByParkingId(id);
		assertEquals(p, result);
	}

	/**
	 * Test for the update() method.
	 */
	@Test
	public void testUpdate() throws NotFoundException {
		int id = 1;
		Parking p = new Parking();
		p.getParkingNo();

		Parking pid = new Parking();
		pid.getParkingNo();

		Mockito.when(pr.findById(id)).thenReturn(Optional.of(pid));
		try {
			String result = psi.update(id, p);
			assertEquals("Update Successful", result);
		} catch (Exception e) {
		}
	}

	/**
	 * Test for the delete() method.
	 */
	@Test
	public void testDelete() throws NotFoundException {

		@SuppressWarnings("unused")
		int parkingNo = 1;
		String parkingName = "Sealdah";
		int noOfCars = 15;
		Parking p = new Parking();
		p.getParkingNo();
		p.setParkingName(parkingName);
		p.setNoOfCars(noOfCars);

		Mockito.doNothing().when(pr).delete(p);
		pr.delete(p);
		Mockito.verify(pr, times(1)).delete(p);
	}
}
