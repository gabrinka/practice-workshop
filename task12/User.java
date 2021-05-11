package com.sap.intern.task12;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1144494671512693561L;
	
	private String userName;
	private String egn;

	public User(final String userName,final String egn) {
		if(userName == null || egn == null) {
			throw new IllegalArgumentException("User name and EGN cannot be null!");
		}
		this.userName = userName;
		this.egn = egn;
	}
//dont need setters,transient

	public String getUserName() {
		return this.userName;
	}

	public String getEgn() {
		return this.egn;
	}
}
