package com.example.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
		
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<String> handlePersonNotFound(Exception ex) {
		return new ResponseEntity<>("Person not found ", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<String> handlePersonAlreadyExists(Exception ex) {
		return new ResponseEntity<>("Person already Exists", HttpStatus.BAD_REQUEST);
	}
}
