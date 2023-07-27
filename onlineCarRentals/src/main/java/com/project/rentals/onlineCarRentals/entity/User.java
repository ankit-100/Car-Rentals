package com.project.rentals.onlineCarRentals.entity;

import jakarta.persistence.Column;
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
 * Represents a user entity in the online car rental system.
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Setter
	private String name;
	@Setter
	@Column(name = "email", unique = true)
	private String email;
	@Setter
	private String password;
	@Setter
	private String phoneNumber;

}
