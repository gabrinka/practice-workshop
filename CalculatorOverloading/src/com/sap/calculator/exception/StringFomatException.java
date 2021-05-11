package com.sap.calculator.exception;

public class StringFomatException extends Exception {
	private static final long serialVersionUID = 1L;

	public StringFomatException(final String message) {
		super(message);
	}

	public StringFomatException(final String message, final Throwable throwable) {
		super(message, throwable);
	}
}
