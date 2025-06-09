package com.example.practice.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.practice.service.impl.ProvinceNamesServiceImpl;

@ExtendWith(MockitoExtension.class)
class ProvinceNamesControllerTest {

//	private final MockMvc mockMvc;

	@Mock
	private ProvinceNamesServiceImpl provinceNamesService;

	@InjectMocks
	private ProvinceNamesController provinceNamesController;


}
