package com.sap.idm.learning.file_manager_server.common_objects;

public enum Status {
	OK(200), CREATED(201), BAD_REQUEST(400), NOT_FOUND(404), INTERNAL_SERVER_ERROR(500), SERVICE_UNAVAILABLE(503);

	private int code;

	private Status(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return super.toString() + "(" + code + ")";
	}

}
