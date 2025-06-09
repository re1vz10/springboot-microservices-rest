package com.example.practice.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.practice.entity.Patient;
import com.example.practice.exception.PatientNotFoundException;
import com.example.practice.repo.PatientRepo;
import com.example.practice.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepo patientRepo;

	@Override
	public Patient addPatient(Patient patient) {
		Patient p = new Patient();
		p.setGender(patient.getGender());
		p.setFirstName(patient.getFirstName());
		p.setLastName(patient.getLastName());
		p.setCity(patient.getCity());
		p.setDateCreated(LocalDateTime.now());
		p.setEmail(patient.getEmail());
		p.setBirthDate(patient.getBirthDate());
		p.setProvinceId(patient.getProvinceId());
		p.setAllergies(patient.getAllergies());
		p.setHeight(patient.getHeight());
		p.setWeight(patient.getWeight());
		return patientRepo.save(p);
	}

	@Override
	public Page<Patient> patients(int size, int page) {
		Pageable pageable = PageRequest.of(size, page);
		return patientRepo.findAll(pageable);
	}

	@Override
	public Optional<Patient> findPatientByFirstName(String firstName) {
		Patient person = patientRepo.findByFirstName(firstName)
				.orElseThrow(() -> new PatientNotFoundException());
		
		return Optional.of(person);
	}

	@Override
	public Optional<Patient> findPatient(Long id) {
		Patient person = patientRepo.findById(id)
				.orElseThrow(); //() -> new PersonNotFoundException());
		
		return Optional.of(person);
	}

	@Override
	public Patient updatePatient(Patient patient, Long id) {
		Patient p = patientRepo.findById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient with ID: " + id + " not found."));
		
		p.setGender(patient.getGender());
		p.setFirstName(patient.getFirstName());
		p.setLastName(patient.getLastName());
		p.setCity(patient.getCity());
		p.setDateCreated(p.getDateCreated());
		p.setEmail(patient.getEmail());
		p.setBirthDate(patient.getBirthDate());
		p.setProvinceId(patient.getProvinceId());
		p.setLastUpdate(LocalDateTime.now());
		p.setAllergies(patient.getAllergies());
		p.setHeight(patient.getHeight());
		p.setWeight(patient.getWeight());
		
		return patientRepo.save(p);
	}

	@Override
	public void deletePatient(Long id) {
		Patient person = patientRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Person with ID: " + id + " not found."));
		
		patientRepo.delete(person);
	}

}
