package com.mam.customexception;

public class mamException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public mamException(String message) {
		super(message);
	}

	public mamException(String message, Throwable cause) {
		super(message, cause);
	}

}
