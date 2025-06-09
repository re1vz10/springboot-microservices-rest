package com.example.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.entity.Doctor;
import com.example.practice.service.impl.DoctorSeviceImpl;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin
public class DoctorController {
	
	@Autowired
	private DoctorSeviceImpl doctorService;
	
	@GetMapping
	public ResponseEntity<Page<Doctor>> doctors(@RequestParam(defaultValue = "0") int size, @RequestParam(defaultValue = "100") int page) {
		return new ResponseEntity<Page<Doctor>>(doctorService.doctors(size, page), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> findDoctor(@PathVariable Long id) {
		return new ResponseEntity<Doctor>(doctorService.findDoctorById(id).get(), HttpStatus.OK);
	}
	
	@GetMapping("/name")
	public ResponseEntity<Doctor> findDoctorByName(@RequestParam String name) {
		return new ResponseEntity<Doctor>(doctorService.findDoctorByFirstName(name).get(), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor, @PathVariable Long id) {
		return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctor, id), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Doctor> add(@RequestBody Doctor doctor) {
		return new ResponseEntity<>(doctorService.addDoctor(doctor) , HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		doctorService.deleteDoctor(id);
		return new ResponseEntity<>("Doctor with ID: " + id + " has been deleted." , HttpStatus.OK);
	}
	

}
