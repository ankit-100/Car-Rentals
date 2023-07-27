package com.project.rentals.carRentals.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.rentals.onlineCarRentals.entity.User;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.repository.UserRepository;
import com.project.rentals.onlineCarRentals.service.UserServiceImpl;

/**
 * Unit tests for the UserServiceImpl class.
 */
@ExtendWith(MockitoExtension.class)
public class UserTest {

	@Mock
	UserRepository ur;

	@InjectMocks
	UserServiceImpl usi;

	// Injection Mocked
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Autowired
	private User u;

	/**
	 * Test for the insert() method when the user already exists.
	 */
	@Test
	public void testInsert_whenUserAlreadyExists_shouldThrowException() {
		// Arrange
		User user = new User();
		Field field = null;
		try {
			field = user.getClass().getDeclaredField("userId");
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		field.setAccessible(true);
		try {
			field.set(user, 1);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		user.setEmail("test@example.com");
		when(ur.existsById(user.getUserId())).thenReturn(true);

		// Act & Assert
		assertThrows(AlreadyPresentException.class, () -> usi.insert(user));
		verify(ur, never()).save(user);
	}

	/**
	 * Test for the insert() method when the user does not exist.
	 */
	@Test
	public void testInsert_whenUserDoesNotExist_shouldInsertUser() throws AlreadyPresentException {
		User user = new User();
		Field field = null;
		try {
			field = user.getClass().getDeclaredField("userId");
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		field.setAccessible(true);
		try {
			field.set(user, 1);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		user.setEmail("test@example.com");
		when(ur.existsById(user.getUserId())).thenReturn(false);
		when(ur.findByEmail(user.getEmail())).thenReturn(null);
		when(ur.save(user)).thenReturn(user);

		User savedUser = usi.insert(user);

		verify(ur).save(user);
		assertEquals(user, savedUser);
	}

	/**
	 * Test for the getAll() method.
	 */
	@Test
	public void testGetAll() {
		when(ur.findAll()).thenReturn(Arrays.asList(u));
		assertThat(usi.getAll()).hasSize(1);
		verify(ur).findAll();
	}

	/**
	 * Test for the insert() method.
	 */
	@Test
	public void testInsert() throws AlreadyPresentException {
		User u = new User();
		u.getUserId();
		Mockito.when(ur.save(Mockito.any())).thenReturn(u);
		User us = usi.insert(u);
		assertEquals(u, us);
	}

	/**
	 * Test for the findByUserId() method.
	 */
	@Test
	public void testFindByUserId() throws NotFoundException {
		int id = 1;
		User u = new User();
		u.getUserId();
		Mockito.when(ur.findById(id)).thenReturn(Optional.of(u));
		User result = usi.findByUserId(id);
		assertEquals(u, result);
	}

	/**
	 * Test for the update() method.
	 */
	@Test
	public void testUpdate() throws NotFoundException {
		int id = 1;
		User u = new User();
		u.getUserId();

		User uid = new User();
		uid.getUserId();

		Mockito.when(ur.findById(id)).thenReturn(Optional.of(uid));
		try {
			String result = usi.update(id, u);
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
		int userId = 1;
		String name = "Ankit";
		String email = "abc@gmail.com";
		String password = "Abc@123";
		String phoneNumber = "9932721685";
		User u = new User();
		u.getUserId();
		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);
		u.setPhoneNumber(phoneNumber);

		Mockito.doNothing().when(ur).delete(u);
		ur.delete(u);
		Mockito.verify(ur, times(1)).delete(u);
	}
}
