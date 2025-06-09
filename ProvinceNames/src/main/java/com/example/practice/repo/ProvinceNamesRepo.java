package com.example.practice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.entity.ProvinceNames;

public interface ProvinceNamesRepo extends JpaRepository<ProvinceNames, String> {
	
	Optional<ProvinceNames> findByProvinceName(String name);

}
