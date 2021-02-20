package com.jobsity.bowling.exceptions;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -449793962215049160L;

	public BusinessException(String message, Throwable t) {
		super(message, t);
	}
	
}
