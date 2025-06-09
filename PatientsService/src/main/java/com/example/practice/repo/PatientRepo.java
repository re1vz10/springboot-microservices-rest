package com.example.practice.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {
	
	Optional<Patient> findByFirstName(String firstName);
	Page<Patient> findAll(Pageable pageable);

}
