package com.example.practice.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.entity.Admission;

public interface AdmissionRepo extends JpaRepository<Admission, Long> {
	
	Optional<List<Admission>> findAdmissionByPatientId(Long id);

}
