package com.project.rentals.onlineCarRentals.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
/**
 * Represents a parking entity in the online car rental system.
 */
@Entity
public class Parking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parkingNo;
	@Setter
	private String parkingName;
	@Setter
	private int noOfCars;
}
