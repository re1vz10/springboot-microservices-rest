package com.example.practice.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.practice.entity.ProvinceNames;

public interface ProvinceNamesService {
	
	ProvinceNames addProvince(ProvinceNames provinceNames);
	Page<ProvinceNames> provinces(int page, int size);
	Optional<ProvinceNames> findByProvinceName(String name);
	Optional<ProvinceNames> findProvinceNamesById(String id);
	void deleteProvince(String id);

}
