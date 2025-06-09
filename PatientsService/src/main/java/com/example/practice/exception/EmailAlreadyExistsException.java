package com.example.practice.exception;

public class EmailAlreadyExistsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5443169678648773104L;
	public EmailAlreadyExistsException() {}
	
	public EmailAlreadyExistsException(String message) {
		super(message);
	}
	

}
