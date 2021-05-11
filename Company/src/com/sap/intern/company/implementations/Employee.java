package com.sap.intern.company.implementations;

public abstract class Employee {
	private String name;
	private String email;

	public Employee(final String name, final String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	abstract public double getTaxPay();

	abstract public int getVacationDays();
}
