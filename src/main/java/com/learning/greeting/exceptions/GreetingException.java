package com.learning.greeting.exceptions;

public class GreetingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	private int errorCode;

	public GreetingException(String message, int errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

}
