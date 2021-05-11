package com.sap.idm.learning.file_manager_server.common_objects;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Response implements Serializable {
	private static final long serialVersionUID = 1289331831892437336L;

	private Status executionStatus;
	private String message;
	private List<String> details;

	public Response(final Status executionStatus, final String message) {
		this.executionStatus = executionStatus;
		this.message = message;
	}

	public Response(final Status executionStatus) {
		this.executionStatus = executionStatus;
	}

	public Response(final Status executionStatus, final String message, final List<String> details) {
		this.executionStatus = executionStatus; //chain constructors
		this.message = message;
		this.details = details;
	}

	public Status getExecutionStatus() {
		return executionStatus;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getResponseDetails() {
		return Collections.unmodifiableList(details);
	}

	@Override
	public String toString() {
		return executionStatus + " " + details;
	}

	public boolean isResponsePositive() {
		return (executionStatus.equals(Status.OK) || executionStatus.equals(Status.CREATED));
	}
}
