package com.example.practice.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.practice.entity.Doctor;

public interface DoctorService {
	
	Doctor addDoctor(Doctor doctor);
	Page<Doctor> doctors(int size, int page);
	Optional<Doctor> findDoctorByFirstName(String firstName);
	Optional<Doctor> findDoctorById(Long id);
	Doctor updateDoctor(Doctor doctor, Long id);
	void deleteDoctor(Long id);

}
