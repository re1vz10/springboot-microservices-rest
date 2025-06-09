package com.example.practice.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.practice.entity.Patient;

public interface PatientService {
	
	Patient addPatient(Patient person);
	Page<Patient> patients(int page, int size);
	Optional<Patient> findPatientByFirstName(String firstName);
	Optional<Patient> findPatient(Long id);
	Patient updatePatient(Patient person, Long id);
	void deletePatient(Long id);
}