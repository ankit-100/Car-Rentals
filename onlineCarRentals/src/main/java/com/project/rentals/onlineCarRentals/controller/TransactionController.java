package com.project.rentals.onlineCarRentals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.rentals.onlineCarRentals.entity.Transaction;
import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
import com.project.rentals.onlineCarRentals.exception.NotFoundException;
import com.project.rentals.onlineCarRentals.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

/*RESTful API controller for handling transaction-related requests.*/
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/Transaction")
public class TransactionController {

	@Autowired
	private TransactionService ts;

	public void setTs(TransactionService ts) {
		this.ts = ts;
	}

	/**
	 * Inserts a new transaction record.
	 *
	 * @param t The transaction object to insert.
	 * @return The inserted transaction object.
	 * @throws AlreadyPresentException If the transaction record already exists.
	 * @throws NotFoundException       If the associated data is not found.
	 */
	@PostMapping("/insert")
	public Transaction insert(@RequestBody Transaction t) throws AlreadyPresentException, NotFoundException {
		log.info("Insert into transaction: {}", t);
		return ts.insert(t);
	}

	/**
	 * Retrieves a transaction record by its ID.
	 *
	 * @param transactionId The ID of the transaction record to retrieve.
	 * @return The retrieved transaction record.
	 * @throws NotFoundException If the transaction record is not found.
	 */
	@GetMapping("/{transactionId}")
	public Transaction findByTransactionId(@PathVariable int transactionId) throws NotFoundException {
		log.info("Find by transactionId: {}", transactionId);
		return ts.findByTransactionId(transactionId);
	}

	/**
	 * Deletes a transaction record by its ID.
	 *
	 * @param transactionId The ID of the transaction record to delete.
	 * @return A success message upon successful deletion.
	 * @throws NotFoundException If the transaction record is not found.
	 */
	@DeleteMapping("/{transactionId}")
	public String deleteByTransactionId(@PathVariable int transactionId) throws NotFoundException {
		log.info("Delete by transactionId: {}", transactionId);
		return ts.delete(transactionId);
	}

	/**
	 * Updates a transaction record by its ID.
	 *
	 * @param transactionId The ID of the transaction record to update.
	 * @param transaction   The updated transaction object.
	 * @return A success message upon successful update.
	 * @throws NotFoundException If the transaction record is not found.
	 */
	@PutMapping("/update/{transactionId}")
	public String update(@PathVariable int transactionId, @RequestBody Transaction transaction)
			throws NotFoundException {
		log.info("Update table by transactionId: {}", transactionId, transaction);
		String result = ts.update(transactionId, transaction);
		return result;
	}

	/**
	 * Retrieves all transaction records.
	 *
	 * @return The list of all transaction records.
	 */
	@GetMapping("/all")
	public List<Transaction> getAll() {
		log.info("Get all data: {}");
		return ts.getAllData();
	}
}
