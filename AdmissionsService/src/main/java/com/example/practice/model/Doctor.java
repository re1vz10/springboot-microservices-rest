package com.example.practice.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Doctor {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String specialty;
}
