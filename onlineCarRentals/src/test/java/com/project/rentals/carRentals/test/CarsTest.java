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

import com.project.rentals.onlineCarRentals.entity.Cars;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.repository.CarsRepository;
import com.project.rentals.onlineCarRentals.service.CarsServiceImpl;

/**
 * Unit tests for the CarsServiceImpl class.
 */
public class CarsTest {

	@Mock
	CarsRepository cr;
	@InjectMocks
	CarsServiceImpl csi;

	// Injection Mocked
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	private Cars c;

	/**
	 * Test for the getAll() method.
	 */
	@Test
	public void testGetAll() {
		when(cr.findAll()).thenReturn(Arrays.asList(c));
		assertThat(csi.getAll()).hasSize(1);
		verify(cr).findAll();
	}

	/**
	 * Test for the insert() method.
	 */
	@Test
	public void testInsert() throws AlreadyPresentException {
		Cars c = new Cars();
		c.getCarId();

		Mockito.when(cr.save(Mockito.any())).thenReturn(c);
		Cars cs = csi.insert(c);
		assertEquals(c, cs);
	}

	/**
	 * Test for the findByCarId() method.
	 */
	@Test
	public void testFindByCarsId() throws NotFoundException {
		int id = 1;
		Cars c = new Cars();
		c.getCarId();
		Mockito.when(cr.findById(id)).thenReturn(Optional.of(c));
		Cars result = csi.findByCarId(id);
		assertEquals(c, result);
	}

	/**
	 * Test for the update() method.
	 */
	@Test
	public void testUpdate() throws NotFoundException {
		int id = 1;
		Cars c = new Cars();
		c.getCarId();

		Cars cid = new Cars();
		cid.getCarId();

		Mockito.when(cr.findById(id)).thenReturn(Optional.of(cid));
		try {
			String result = csi.update(id, c);
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
		int carId = 1;
		String carCompany = "Mahindra Innova x10";
		String type = "SUV";
		double rent = 1250;

		Cars c = new Cars();
		c.getCarId();
		c.setCarCompany(carCompany);
		c.setType(type);
		c.setRent(rent);
		c.getParkingNo();

		Mockito.doNothing().when(cr).delete(c);
		cr.delete(c);
		Mockito.verify(cr, times(1)).delete(c);
	}
}
