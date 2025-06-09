package com.example.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.practice.entity.Admission;

public interface AdmissionService {
	
	Admission add(Admission admission);
	Page<Admission> admissions(int size, int page);
	Optional<Admission> findAdmissionByPatientId(Long id);
	Admission updateAdmission(Admission admission, Long id);
	List<Admission> getAdmissionByPatientId(Long id);
	void deleteAdmission(Long id);

}
