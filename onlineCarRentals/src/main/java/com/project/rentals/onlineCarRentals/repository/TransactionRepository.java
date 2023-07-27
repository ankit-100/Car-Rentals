package com.project.rentals.onlineCarRentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.rentals.onlineCarRentals.entity.Transaction;

/*Repository interface for accessing and manipulating transaction 
  data in the database.*/
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
