/*package com.project.rentals.carRentals.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.rentals.onlineCarRentals.entity.Transaction;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.repository.TransactionRepository;
import com.project.rentals.onlineCarRentals.service.CarsServiceImpl;
import com.project.rentals.onlineCarRentals.service.TransactionServiceImpl;

public class TransactionTest {

	@Mock
	TransactionRepository tr;
	@Mock
	CarsServiceImpl csi;
	@InjectMocks
	TransactionServiceImpl tsi;

	// Injection Mocked
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	private Transaction t;

	@Test
	public void testGetAll() {
		when(tr.findAll()).thenReturn(Arrays.asList(t));
		assertThat(tsi.getAllData()).hasSize(1);
		verify(tr).findAll();
	}

	
	@Test
	public void testFindByTransactionId() throws NotFoundException {
		int id = 1;
		Transaction t = new Transaction();
		t.getTransactionId();
		Mockito.when(tr.findById(id)).thenReturn(Optional.of(t));
		Transaction result = tsi.findByTransactionId(id);
		assertEquals(t, result);
	}

	@Test
	public void testUpdate() throws NotFoundException {
		int id = 1;
		Transaction t = new Transaction();
		t.getTransactionId();

		Transaction tid = new Transaction();
		tid.getTransactionId();

		Mockito.when(tr.findById(id)).thenReturn(Optional.of(tid));
		try {
			String result = tsi.update(id, t);
			assertEquals("Update Successful", result);
		} catch (Exception e) {
		}
	}

	@Test
	public void testDelete() throws NotFoundException {

		@SuppressWarnings("unused")
		int transactionId = 1;
		Date pickupDate = Date.valueOf("2023-04-24");// wrong value
		Date returnDate = Date.valueOf("2023-05-14");
		String dlNo = "kjhe37i4ywrhuwy";
		String modeOfPayment = "upi";
		double cost = 5000;

		Transaction t = new Transaction();
		t.getTransactionId();
		t.setPickupDate(pickupDate);
		t.setReturnDate(returnDate);
		t.setDlNo(dlNo);
		t.setModeOfPayment(modeOfPayment);
		t.setCost(cost);
		t.getCarId();
		t.getUserId();

		Mockito.doNothing().when(tr).delete(t);
		tr.delete(t);
		Mockito.verify(tr, times(1)).delete(t);
	}
}*/

package com.project.rentals.carRentals.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.sql.Date;
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

import com.project.rentals.onlineCarRentals.entity.Cars;
import com.project.rentals.onlineCarRentals.entity.Transaction;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.repository.TransactionRepository;
import com.project.rentals.onlineCarRentals.service.CarsServiceImpl;
import com.project.rentals.onlineCarRentals.service.TransactionServiceImpl;

/**
 * Unit tests for the CarsServiceImpl class.
 */
@ExtendWith(MockitoExtension.class)
public class TransactionTest {

	@Mock
	TransactionRepository tr;

	@Mock
	CarsServiceImpl csi;

	@InjectMocks
	TransactionServiceImpl tsi;

	// Injection Mocked
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Autowired
	private Transaction t;

	/**
	 * Test for the insert() method.
	 */
	@Test
	void testInsert() throws AlreadyPresentException, NotFoundException {
		Transaction inputTransaction = new Transaction();
		Field field = null;
		try {
			field = inputTransaction.getClass().getDeclaredField("transactionId");
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		field.setAccessible(true);
		try {
			field.set(inputTransaction, 1);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		inputTransaction.setPickupDate(Date.valueOf("2023-05-02"));
		inputTransaction.setReturnDate(Date.valueOf("2023-05-12"));

		Cars car = new Cars();
		field = null;
		try {
			field = car.getClass().getDeclaredField("carId");
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		field.setAccessible(true);
		try {
			field.set(car, 1);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		inputTransaction.setCars(car);
		inputTransaction.setCarId(1);
		car.setRent(50.0);

		when(csi.findByCarId(Mockito.anyInt())).thenReturn(car);
		when(tr.save(inputTransaction)).thenReturn(inputTransaction);
		Transaction savedTransaction = tsi.insert(inputTransaction);
		verify(tr).save(inputTransaction);
		assertEquals(inputTransaction, savedTransaction);
	}

	/**
	 * Test for the getAllData() method.
	 */
	@Test
	public void testGetAll() {
		when(tr.findAll()).thenReturn(Arrays.asList(t));
		assertThat(tsi.getAllData()).hasSize(1);
		verify(tr).findAll();
	}

	/**
	 * Test for the findByTransactionId() method.
	 */
	@Test
	public void testFindByTransactionId() throws NotFoundException {
		int id = 1;
		Transaction t = new Transaction();
		t.getTransactionId();
		Mockito.when(tr.findById(id)).thenReturn(Optional.of(t));
		Transaction result = tsi.findByTransactionId(id);
		assertEquals(t, result);
	}

	/**
	 * Test for the update() method.
	 */
	@Test
	public void testUpdate() throws NotFoundException {
		int id = 1;
		Transaction t = new Transaction();
		t.getTransactionId();

		Transaction tid = new Transaction();
		tid.getTransactionId();

		Mockito.when(tr.findById(id)).thenReturn(Optional.of(tid));
		try {
			String result = tsi.update(id, t);
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
		int transactionId = 1;
		Date pickupDate = Date.valueOf("2023-04-24");// wrong value
		Date returnDate = Date.valueOf("2023-05-14");
		String dlNo = "kjhe37i4ywrhuwy";
		String modeOfPayment = "upi";
		double cost = 5000;

		Transaction t = new Transaction();
		t.getTransactionId();
		t.setPickupDate(pickupDate);
		t.setReturnDate(returnDate);
		t.setDlNo(dlNo);
		t.setModeOfPayment(modeOfPayment);
		t.setCost(cost);
		t.getCarId();
		t.getUserId();

		Mockito.doNothing().when(tr).delete(t);
		tr.delete(t);
		Mockito.verify(tr, times(1)).delete(t);
	}
}
