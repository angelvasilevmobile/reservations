package com.example.reservations.exception;

public class PaymentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7221028459298534413L;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PaymentException(String message) {
		super();
		this.message = message;
	}
	
	
}
