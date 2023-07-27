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

import com.project.rentals.onlineCarRentals.controller.TransactionController;
import com.project.rentals.onlineCarRentals.entity.Transaction;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.service.TransactionService;

public class TransactionControllerTest {

	@Mock
	TransactionService ts;
	@InjectMocks
	TransactionController tc;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test for the insert() method in TransactionController.
	 */
	@Test
	public void testInsert() throws AlreadyPresentException, NotFoundException {

		TransactionService ts = Mockito.mock(TransactionService.class);
		TransactionController tc = new TransactionController();
		tc.setTs(ts);
		Transaction t = new Transaction();
		Mockito.when(ts.insert(Mockito.any(Transaction.class))).thenReturn(t);
		Transaction result = tc.insert(t);
		assertNotNull(result);
	}

	/**
	 * Test for the findByTransactionId() method in TransactionController.
	 */
	@Test
	public void testFindById() throws NotFoundException {
		TransactionService ts = Mockito.mock(TransactionService.class);
		TransactionController tc = new TransactionController();
		tc.setTs(ts);
		int transactionId = 1;
		Mockito.when(ts.findByTransactionId(transactionId)).thenReturn(new Transaction());
		Transaction result = tc.findByTransactionId(transactionId);
		assertNotNull(result);
	}

	/**
	 * Test for the deleteByTransactionId() method in TransactionController.
	 */
	@Test
	public void testDeleteById() throws NotFoundException {
		TransactionService ts = Mockito.mock(TransactionService.class);
		TransactionController tc = new TransactionController();
		tc.setTs(ts);
		int transactionId = 1;
		Mockito.when(ts.delete(transactionId)).thenReturn("Deleted");
		String result = tc.deleteByTransactionId(transactionId);
		assertEquals("Deleted", result);
	}

	/**
	 * Test for the update() method in TransactionController.
	 */
	@Test
	public void testUpdate() throws NotFoundException {
		TransactionService ts = Mockito.mock(TransactionService.class);
		TransactionController tc = new TransactionController();
		tc.setTs(ts);
		int transactionId = 1;
		Transaction t = new Transaction();
		Mockito.when(ts.update(transactionId, t)).thenReturn("Updated");
		String result = tc.update(transactionId, t);
		assertEquals("Updated", result);
	}

	/**
	 * Test for the getAll() method in TransactionController.
	 */
	@Test
	public void testGetAllTransactionTables() {
		TransactionService ts = Mockito.mock(TransactionService.class);
		TransactionController tc = new TransactionController();
		tc.setTs(ts);
		List<Transaction> c = new ArrayList<>();
		Mockito.when(ts.getAllData()).thenReturn(c);
		List<Transaction> result = tc.getAll();
		assertNotNull(result);
	}

}
