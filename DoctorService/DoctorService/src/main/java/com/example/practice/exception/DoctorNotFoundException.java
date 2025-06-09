package com.example.practice.exception;

public class DoctorNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6803957024308091638L;
	
	public DoctorNotFoundException() {}
	
	public DoctorNotFoundException(String msg) {
		super(msg);
	}

}
