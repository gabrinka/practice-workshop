package com.sap.idm.learning.exceptions;

public class FileOperationException extends Exception {
	private static final long serialVersionUID = 1L;

	public FileOperationException(final String message, Throwable cause) {
		super(message, cause);
	}

	public FileOperationException(final String message) {
		super(message);
	}
}
