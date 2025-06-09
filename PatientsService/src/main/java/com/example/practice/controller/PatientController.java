/**
 * 
 */
package com.example.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.entity.Patient;
import com.example.practice.service.impl.PatientServiceImpl;

import jakarta.validation.Valid;

/**
 * @author Reivin Bigalbal
 *
 */
@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	@Autowired
	private PatientServiceImpl patientService;
	
	@GetMapping("/hello")
	public String Hello(@RequestParam(value = "name", required = false, defaultValue = "Guest") String name) {
		return "Hello " + name + ", how are you?";
	}
	
	@PostMapping("/add")
	public ResponseEntity<Patient> savePerson(@RequestBody Patient person) {
		return new ResponseEntity<Patient>(patientService.addPatient(person), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Page<Patient>> persons(@RequestParam(defaultValue = "0") int size, @RequestParam(defaultValue = "100") int page) {
		return new ResponseEntity<Page<Patient>>(patientService.patients(size, page), HttpStatus.OK);
	}
	
	@GetMapping("/patient")
	public ResponseEntity<Patient> getPersonByName(@RequestParam String name) {
		return new ResponseEntity<Patient>(patientService.findPatientByFirstName(name).get(), HttpStatus.OK);
	}
	
	@GetMapping("/patient/{id}")
	public ResponseEntity<Patient> getPersonById(@PathVariable Long id) {
		return new ResponseEntity<Patient>(patientService.findPatient(id).get(), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Patient> updatePerson(@Valid @RequestBody Patient person, @PathVariable Long id) {
		return new ResponseEntity<Patient>(patientService.updatePatient(person, id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
		patientService.deletePatient(id);
		return ResponseEntity.ok("Person deleted successfully.");
	}
	
}
