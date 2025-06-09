package com.example.practice.exception;

public class ProvinceNameNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9177890977965155701L;
	
	public ProvinceNameNotFound(String message) {
		super(message);
	}

}
