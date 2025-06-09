package com.example.practice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.practice.entity.ProvinceNames;
import com.example.practice.exception.ProvinceNameAlreadyExistException;
import com.example.practice.exception.ProvinceNameNotFound;
import com.example.practice.repo.ProvinceNamesRepo;
import com.example.practice.service.ProvinceNamesService;

@Service
public class ProvinceNamesServiceImpl implements ProvinceNamesService {
	
	@Autowired
	private ProvinceNamesRepo provinceNamesRepo;

	@Override
	public ProvinceNames addProvince(ProvinceNames provinceNames) {
		Optional<ProvinceNames> pn = provinceNamesRepo.findById(provinceNames.getProvinceId());
		if(pn.isPresent()) {
			throw new ProvinceNameAlreadyExistException(provinceNames.getProvinceName() + " already exists.");
		}
		
		return provinceNamesRepo.save(provinceNames);
	}

	@Override
	public Page<ProvinceNames> provinces(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return provinceNamesRepo.findAll(pageable);
	}

	@Override
	public Optional<ProvinceNames> findByProvinceName(String name) {
		Optional<ProvinceNames> op = provinceNamesRepo.findByProvinceName(name);
		if(op.isEmpty()) throw new ProvinceNameNotFound("Province name: " + name + " not found.");
		
		return op;
	}

	@Override
	public Optional<ProvinceNames> findProvinceNamesById(String id) {
		Optional<ProvinceNames> op = provinceNamesRepo.findById(id);
		if(op.isEmpty()) throw new ProvinceNameNotFound("Province name: " + id + " not found.");
		
		return op;
	}

	@Override
	public void deleteProvince(String id) {
		Optional<ProvinceNames> op = provinceNamesRepo.findById(id);
		if(op.isEmpty()) throw new ProvinceNameNotFound("Province name: " + id + " not found.");
		
		provinceNamesRepo.deleteById(id);
		
	}
	
	

}
