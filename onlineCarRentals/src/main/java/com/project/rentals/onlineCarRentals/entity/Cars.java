package com.project.rentals.onlineCarRentals.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

/**
 * Represents a car entity in the online car rental system.
 */
@Entity
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	@Setter
	private String carCompany;
	@Setter
	private String type;
	@Setter
	private double rent;
	@ManyToOne
	@JoinColumn(name = "parkingNo")
	private Parking parkingNo;
}
