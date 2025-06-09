package com.example.practice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Long>{
	
	Optional<Doctor> findByFirstName(String firstName);

}
