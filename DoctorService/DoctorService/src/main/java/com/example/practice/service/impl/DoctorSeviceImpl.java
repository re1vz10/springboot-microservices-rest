package com.example.practice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.practice.entity.Doctor;
import com.example.practice.exception.DoctorNotFoundException;
import com.example.practice.repo.DoctorRepo;
import com.example.practice.service.DoctorService;

@Service
public class DoctorSeviceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepo doctorRepo;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}

	@Override
	public Page<Doctor> doctors(int size, int page) {
		Pageable pageable = PageRequest.of(size, page);
		return doctorRepo.findAll(pageable);
	}

	@Override
	public Optional<Doctor> findDoctorByFirstName(String firstName) {
		Doctor doctor = doctorRepo.findByFirstName(firstName)
				.orElseThrow();
		
		return Optional.of(doctor);
	}

	@Override
	public Optional<Doctor> findDoctorById(Long id) {
		Doctor doctor = doctorRepo.findById(id)
				.orElseThrow(() -> new DoctorNotFoundException());
		
		return Optional.of(doctor);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor, Long id) {
		Doctor doctor2 = findDoctorById(id)
				.orElseThrow(() -> new DoctorNotFoundException("Doctor with ID: " + id + " not found."));
		
		doctor2.setFirstName(doctor.getFirstName());
		doctor2.setLastName(doctor.getLastName());
		doctor2.setSpecialty(doctor.getSpecialty());
		
		return doctorRepo.save(doctor2);
	}

	@Override
	public void deleteDoctor(Long id) {
		Doctor doctor = findDoctorById(id)
				.orElseThrow(() -> new DoctorNotFoundException());
		
		doctorRepo.delete(doctor);
	}
	
}
