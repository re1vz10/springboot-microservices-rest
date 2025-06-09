package com.example.practice.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	@Size(min = 2, max = 20, message = "first name must be between 2 and 20 characters")
	private String firstName;
	
	@Column(name = "last_name")
	@Size(min = 2, max = 20, message = "last name must be between 2 and 20 characters")
	private String lastName;
	
	@NotNull
	@Pattern(regexp = "^[MF]$", message = "Gender must be M or F only.")
	private String gender;
	
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Invalid email format")
	private String email;
	
	@NotNull(message = "This is required.")
	private String city;
	
	@Column(name = "birth_date")
	@Past(message = "birth date must be in the past")
	private LocalDate birthDate;
	
	@Column(name = "province_id")
	private String provinceId;
	
	@Column(name = "date_created")
//	@Temporal(TemporalType.DATE)
	private LocalDateTime dateCreated;
	
	@Nullable
	@Column(name = "last_update")
	private LocalDateTime lastUpdate;
	
	@Nullable
	private String allergies;
	
	@NotNull(message = "This is required.")
	private Integer height;
	
	@NotNull(message = "This is required.")
	private Integer weight;
	
	@Version
	private Integer version;
	
}
