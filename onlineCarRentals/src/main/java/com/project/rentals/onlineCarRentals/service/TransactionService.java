package com.project.rentals.onlineCarRentals.service;

import java.util.List;

import com.project.rentals.onlineCarRentals.entity.Transaction;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;

/*Service interface for managing transaction-related operations.*/
public interface TransactionService {

	/* Inserts a new transaction into the system. */
	public Transaction insert(Transaction t) throws AlreadyPresentException, NotFoundException;

	/* Retrieves a transaction by its transaction ID. */
	public Transaction findByTransactionId(int transactionId) throws NotFoundException;

	/* Deletes a transaction from the system. */
	public String delete(int transactionId) throws NotFoundException;

	/* Updates the details of a transaction. */
	public String update(int transactionId, Transaction transaction) throws NotFoundException;

	/* Retrieves a list of all transaction in the system. */
	public List<Transaction> getAllData();
}
