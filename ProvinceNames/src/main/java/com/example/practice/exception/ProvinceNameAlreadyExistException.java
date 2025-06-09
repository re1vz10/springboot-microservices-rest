package com.example.practice.exception;

public class ProvinceNameAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4642055718459427607L;
	
	public ProvinceNameAlreadyExistException() {};
	
	public ProvinceNameAlreadyExistException(String message) {
		super(message);
	}

}
