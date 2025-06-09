package com.example.practice.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.entity.ProvinceNames;
import com.example.practice.service.impl.ProvinceNamesServiceImpl;

@RestController
@RequestMapping("/api/province_names")
public class ProvinceNamesController {
	
	@Autowired
	private ProvinceNamesServiceImpl provinceNamesService;
	
	@GetMapping
	public ResponseEntity<Page<ProvinceNames>> provinceNames
		(@RequestParam(required = false, defaultValue = "0") int page, @RequestParam(required = false, defaultValue = "20") int size) {
		return new ResponseEntity<>(provinceNamesService.provinces(page, size), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProvinceNames> findById(@PathVariable String id) {
		return new ResponseEntity<ProvinceNames>(provinceNamesService.findProvinceNamesById(id).get(), HttpStatus.OK);
	}
	
	@GetMapping("/province")
	public ResponseEntity<ProvinceNames> findByName(@RequestParam String name) throws UnsupportedEncodingException {
		String encoded = URLEncoder.encode(name, StandardCharsets.UTF_8.toString());
		System.out.println(encoded);
		return new ResponseEntity<ProvinceNames>(provinceNamesService.findByProvinceName(name).get() , HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<ProvinceNames> add(@RequestBody ProvinceNames provinceNames) {
		return new ResponseEntity<ProvinceNames>(provinceNamesService.addProvince(provinceNames), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		provinceNamesService.deleteProvince(id);
		return new ResponseEntity<>("Province name with ID: " + id + " now deleted.", HttpStatus.OK);
	}
	
	

}
