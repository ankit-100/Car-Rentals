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

import com.project.rentals.onlineCarRentals.controller.UserController;
import com.project.rentals.onlineCarRentals.entity.User;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.service.UserService;

public class UserControllerTest {

	@Mock
	UserService us;
	@InjectMocks
	UserController uc;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test for the insert() method in UserController.
	 */
	@Test
	public void testInsert() throws AlreadyPresentException {

		UserService us = Mockito.mock(UserService.class);
		UserController uc = new UserController();
		uc.setUs(us);
		User u = new User();
		Mockito.when(us.insert(Mockito.any(User.class))).thenReturn(u);
		User result = uc.insert(u);
		assertNotNull(result);
	}

	/**
	 * Test for the findByUserId() method in UserController.
	 */
	@Test
	public void testFindById() throws NotFoundException {
		UserService us = Mockito.mock(UserService.class);
		UserController uc = new UserController();
		uc.setUs(us);
		int userId = 1;
		Mockito.when(us.findByUserId(userId)).thenReturn(new User());
		User result = uc.findByUserId(userId);
		assertNotNull(result);
	}

	/**
	 * Test for the deleteByUserId() method in UserController.
	 */
	@Test
	public void testDeleteById() throws NotFoundException {
		UserService us = Mockito.mock(UserService.class);
		UserController uc = new UserController();
		uc.setUs(us);
		int userId = 1;
		Mockito.when(us.delete(userId)).thenReturn("Deleted");
		String result = uc.deleteByUserId(userId);
		assertEquals("Deleted", result);
	}

	/**
	 * Test for the update() method in UserController.
	 */
	@Test
	public void testUpdate() throws NotFoundException {
		UserService us = Mockito.mock(UserService.class);
		UserController uc = new UserController();
		uc.setUs(us);
		int userId = 1;
		User u = new User();
		Mockito.when(us.update(userId, u)).thenReturn("Updated");
		String result = uc.update(userId, u);
		assertEquals("Updated", result);
	}

	/**
	 * Test for the getAll() method in UserController.
	 */
	@Test
	public void testGetAllUserTables() {
		UserService us = Mockito.mock(UserService.class);
		UserController uc = new UserController();
		uc.setUs(us);
		List<User> u = new ArrayList<>();
		Mockito.when(us.getAll()).thenReturn(u);
		List<User> result = uc.getAll();
		assertNotNull(result);
	}
}
