package com.example.practice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.practice.model.Patient;

@FeignClient(name = "patient-service", url = "http://localhost:8083/api/patients")
public interface FeignClientPlaceHolder {
	
	@GetMapping
	Page<Patient> getPatients();
	
}
