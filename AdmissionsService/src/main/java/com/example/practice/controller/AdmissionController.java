package com.example.practice.controller;

import java.util.List;

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

import com.example.practice.entity.Admission;
import com.example.practice.service.AdmissionService;

@RestController
@RequestMapping("/api/admissions")
public class AdmissionController {
	
	@Autowired
	private AdmissionService admissionService;
	
	@GetMapping
	public ResponseEntity<Page<Admission>> admissions
		(@RequestParam(defaultValue = "0", required = false) int page, @RequestParam(defaultValue = "20", required = false) int size) {
		return new ResponseEntity<>(admissionService.admissions(page, size), HttpStatus.OK); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Admission>> getAdmissionsByPatientId(@PathVariable Long id) {
		return new ResponseEntity<>(admissionService.getAdmissionByPatientId(id), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Admission> add(@RequestBody Admission admission) {
		return new ResponseEntity<>(admissionService.add(admission), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Admission> update(@RequestBody Admission admission, @PathVariable Long id) {
		return new ResponseEntity<>(admissionService.updateAdmission(admission, id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		admissionService.deleteAdmission(id);
		return new ResponseEntity<>("Admission with ID: " + id + " deleted." , HttpStatus.OK);
	}
	
	

}
