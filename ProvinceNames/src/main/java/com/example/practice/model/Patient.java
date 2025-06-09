package com.example.practice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

	private Long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String city;
	private LocalDate birthDate;
	private String provinceId;
	private LocalDateTime dateCreated;
	private LocalDateTime lastUpdate;
	private String allergies;
	private Integer height;
	private Integer weight;
	private Integer version;

}
