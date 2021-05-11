package com.sap.idm.learning.exceptions;

public class UnexpectedArgumentsException extends Exception {
	private static final long serialVersionUID = 1L;

	public UnexpectedArgumentsException(final String message) {
		super(message);
	}

	public UnexpectedArgumentsException(final String message, Throwable cause) {
		super(message, cause);
	}

}
