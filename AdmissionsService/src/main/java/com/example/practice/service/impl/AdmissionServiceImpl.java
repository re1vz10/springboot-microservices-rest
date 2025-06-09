package com.example.practice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.practice.entity.Admission;
import com.example.practice.repo.AdmissionRepo;
import com.example.practice.service.AdmissionService;

@Service
public class AdmissionServiceImpl implements AdmissionService {
	
	@Autowired
	private AdmissionRepo admissionRepo;
	
	@Override
	public Admission add(Admission admission) {
		return admissionRepo.save(admission);
	}

	@Override
	public Page<Admission> admissions(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return admissionRepo.findAll(pageable);
	}

	@Override
	public Optional<Admission> findAdmissionByPatientId(Long id) {
		Optional<Admission> op = admissionRepo.findById(id);
		if(op.isEmpty()) throw new RuntimeException("Not found.");
		
		return op;
	}

	@Override
	public Admission updateAdmission(Admission admission, Long id) {
		Admission ad = admissionRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Admission with ID: " + id + " not found."));
		
		ad.setAdmissionDate(admission.getAdmissionDate());
		ad.setDischargeDate(admission.getDischargeDate());
		ad.setDiagnosis(admission.getDiagnosis());
		ad.setPatientId(admission.getPatientId());
		ad.setAttendingDoctorid(admission.getAttendingDoctorid());
		
		return admissionRepo.save(ad);
	}

	@Override
	public List<Admission> getAdmissionByPatientId(Long id) {
		Optional<List<Admission>> op = admissionRepo.findAdmissionByPatientId(id);
		if(op.isEmpty()) throw new RuntimeException("Patient ID not found.");
		
		return op.get();
	}

	@Override
	public void deleteAdmission(Long id) {
		Admission ad = admissionRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Admission with ID: " + id + " not found."));
		
		admissionRepo.delete(ad);
		
	}

}
