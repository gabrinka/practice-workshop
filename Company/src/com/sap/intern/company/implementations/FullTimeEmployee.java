package com.sap.intern.company.implementations;

public class FullTimeEmployee extends Employee {
	private final static int VACATION_DAYS = 30;
	private double taxPay;

	public FullTimeEmployee(final String name, final String email, double taxPay) {
		super(name, email);
		this.taxPay = taxPay;
	}

	@Override
	public double getTaxPay() {
		return taxPay;
	}

	@Override
	public int getVacationDays() {
		return VACATION_DAYS;
	}
}
