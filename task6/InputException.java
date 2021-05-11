package com.sap.intern.task6;

public class InputException extends Exception{
	private static final long serialVersionUID = 1L;

	public InputException(final String message, Throwable cause) {
		super(message, cause);
	}

	public InputException(final String message) {
		super(message);
	}
}
