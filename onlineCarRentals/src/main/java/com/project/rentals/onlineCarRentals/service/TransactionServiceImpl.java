package com.project.rentals.onlineCarRentals.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.rentals.onlineCarRentals.entity.Cars;
import com.project.rentals.onlineCarRentals.entity.Transaction;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.repository.TransactionRepository;

import lombok.extern.slf4j.Slf4j;

/*Service implementation for managing transaction-related operations.*/
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository tr;

	@Autowired
	private CarsServiceImpl csi;

	/*
	 * Inserts a new transaction into the system.
	 * 
	 * @param t The transaction to be inserted.
	 * 
	 * @return The inserted transaction.
	 * 
	 * @throws AlreadyPresentException If the transaction ID already exists in the
	 * system.
	 * 
	 * @throws NotFoundException If the associated car is not found in the system.
	 */
	@Override
	public Transaction insert(Transaction t) throws AlreadyPresentException, NotFoundException {
		log.info("Insert into transaction: {}", t);
		if (tr.existsById(t.getTransactionId())) {
			throw new AlreadyPresentException();
		}

		Date pickupDate = t.getPickupDate();
		Date returnDate = t.getReturnDate();
		double noOfDays = 0;

		int carId = t.getCars().getCarId();
		Cars c = csi.findByCarId(carId);
		double rent = c.getRent();

		if (t.getPickupDate().compareTo(returnDate) < 0) {
			// Calculate the difference between the two dates in milliseconds
			long differenceInMs = returnDate.getTime() - pickupDate.getTime();

			// Convert the milliseconds to days
			noOfDays = TimeUnit.DAYS.convert(differenceInMs, TimeUnit.MILLISECONDS);
		}

		// Calculation of cost based on rent of car and no of days booked
		double cost = rent * noOfDays;

		// Calculation of discount based on total amount
		double discount = 0;
		if (cost > 3000) {
			discount = cost * 0.03;
			cost -= discount;
		}

		// Calculation of tax on total cost
		double tax = cost * 0.05;
		cost += tax;

		// Round the variables to two decimal places
		DecimalFormat df = new DecimalFormat("#.##");
		rent = Double.parseDouble(df.format(rent));
		cost = Double.parseDouble(df.format(cost));
		discount = Double.parseDouble(df.format(discount));
		tax = Double.parseDouble(df.format(tax));

		// Setting values
		t.setDiscount(discount);
		t.setTax(tax);
		t.setCost(cost);
		t.setCarId(carId);

		return tr.save(t);
	}

	/**
	 * Retrieves a transaction by its transaction ID.
	 *
	 * @param transactionId The transaction ID to retrieve the transaction.
	 * @return The retrieved transaction.
	 * @throws NotFoundException If the transaction with the given ID is not found.
	 */
	@Override
	public Transaction findByTransactionId(int transactionId) throws NotFoundException {
		log.info("Find by transactionId: {}", transactionId);
		Transaction transaction;
		if (tr.findById(transactionId).isEmpty()) {
			throw new NotFoundException();
		} else {
			transaction = tr.findById(transactionId).get();
		}
		return transaction;
	}

	/**
	 * Deletes a transaction from the system.
	 *
	 * @param transactionId The transaction ID of the transaction to delete.
	 * @return A message indicating the success or failure of the deletion
	 *         operation.
	 * @throws NotFoundException If the transaction with the given ID is not found.
	 */
	@Override
	public String delete(int transactionId) throws NotFoundException {
		log.info("Delete by transactionId: {}", transactionId);
		if (tr.findById(transactionId).isEmpty()) {
			throw new NotFoundException();
		}
		tr.deleteById(transactionId);
		return "Delete Successful";
	}

	/**
	 * Updates the details of a transaction.
	 *
	 * @param transactionId The transaction ID of the transaction to update.
	 * @param transaction   The updated transaction.
	 * @return A message indicating the success or failure of the update operation.
	 * @throws NotFoundException If the transaction with the given ID is not found.
	 */
	@Override
	public String update(int transactionId, Transaction transaction) throws NotFoundException {
		log.info("Update table by transactionId: {}", transactionId, transaction);
		if (tr.findById(transactionId).isEmpty()) {
			throw new NotFoundException();
		} else {
			tr.save(transaction);
		}
		return "Update Successful";
	}

	/**
	 * Retrieves a list of all transactions in the system.
	 *
	 * @return A list of all transactions.
	 */
	@Override
	public List<Transaction> getAllData() {
		log.info("Get all data: {}");
		return tr.findAll();
	}

}
