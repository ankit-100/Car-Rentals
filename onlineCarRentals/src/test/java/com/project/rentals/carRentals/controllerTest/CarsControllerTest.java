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

import com.project.rentals.onlineCarRentals.controller.CarsController;
import com.project.rentals.onlineCarRentals.entity.Cars;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.service.CarsService;

public class CarsControllerTest {

	@Mock
	CarsService cs;
	@InjectMocks
	CarsController cc;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
	MockitoAnnotations.initMocks(this);
	}
	/**
	 * Test for the insert() method in CarsController.
	 */
	@Test
	public void testInsert() throws AlreadyPresentException {

		CarsService cs = Mockito.mock(CarsService.class);
		CarsController cc = new CarsController();
		cc.setCs(cs);
		Cars c = new Cars();
		Mockito.when(cs.insert(Mockito.any(Cars.class))).thenReturn(c);
		Cars result = cc.insert(c);
		assertNotNull(result);
	}
	/**
	 * Test for the findByCarId() method in CarsController.
	 */
	@Test
	public void testFindById() throws NotFoundException 
	{
		CarsService cs = Mockito.mock(CarsService.class);
		CarsController cc = new CarsController();
		cc.setCs(cs);
		int carId = 1;
		Mockito.when(cs.findByCarId(carId)).thenReturn(new Cars());
		Cars result = cc.findByCarId(carId);
		assertNotNull(result);
	}
	/**
	 * Test for the deleteByCarId() method in CarsController.
	 */
	@Test
	public void testDeleteById() throws NotFoundException 
	{
		CarsService cs = Mockito.mock(CarsService.class);
		CarsController cc = new CarsController();
		cc.setCs(cs);
		int carId = 1;
		Mockito.when(cs.delete(carId)).thenReturn("Deleted");
		String result = cc.deleteByCarId(carId);
		assertEquals("Deleted", result);
	}
	/**
	 * Test for the update() method in CarsController.
	 */
	@Test
	public void testUpdate() throws NotFoundException 
	{
		CarsService cs = Mockito.mock(CarsService.class);
		CarsController cc = new CarsController();
		cc.setCs(cs);
		int carId = 1;
		Cars c = new Cars();
		Mockito.when(cs.update(carId, c)).thenReturn("Updated");
		String result = cc.update(carId, c);
		assertEquals("Updated", result);
	}
	/**
	 * Test for the getAll() method in CarsController.
	 */
	@Test
	public void testGetAllCarsTables() 
	{
		CarsService cs = Mockito.mock(CarsService.class);
		CarsController cc = new CarsController();
		cc.setCs(cs);
		List<Cars> c = new ArrayList<>();
		Mockito.when(cs.getAll()).thenReturn(c);
		List<Cars> result = cc.getAll();
		assertNotNull(result);
	}
}
