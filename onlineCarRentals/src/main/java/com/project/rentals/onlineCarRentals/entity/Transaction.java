package com.project.rentals.onlineCarRentals.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
/* Represents a transaction entity in the online car rental system. */
@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	@Setter
	private Date pickupDate;
	@Setter
	private Date returnDate;
	@Setter
	private String dlNo;
	@Setter
	private String modeOfPayment;
	@Setter
	private double cost;
	@Setter
	private double discount;
	@Setter
	private double tax;
	@Setter
	@ManyToOne
	@JoinColumn(name = "carId", nullable = false, insertable = false, updatable = false)
	private Cars cars;
	@Setter
	@JsonIgnore
	private int carId;
	@Setter
	@ManyToOne
	@JoinColumn(name = "userId")
	private User userId;
}
