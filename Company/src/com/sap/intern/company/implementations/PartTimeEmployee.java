package com.sap.intern.company.implementations;

public class PartTimeEmployee extends Employee {
	private final static int VACATION_DAYS = 20;
	private final static int TAX_PAY = 0;

	public PartTimeEmployee(final String name, final String email) {
		super(name, email);
	}

	@Override
	public int getVacationDays() {
		return VACATION_DAYS;
	}

	@Override
	public double getTaxPay() {
		return TAX_PAY;
	}
}
