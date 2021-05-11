package com.sap.intern.company.implementations;

import java.util.Collections;
import java.util.List;

public class Department {
	private Employee manager;
	private String name;
	private List<Employee> employees;

	public Department(final Employee manager, final String name, final List<Employee> employees) {
		this.manager = manager;
		this.name = name;
		this.employees = employees;
	}

	public Employee getManager() {
		return manager;
	}

	public String getName() {
		return name;
	}

	public List<Employee> getEmployees() {
		return Collections.unmodifiableList(employees);
	}

	public int getTotalEmployeesVacationDays() {
		int totalVacationDays = 0;
		totalVacationDays = getManager().getVacationDays();

		for (Employee employee : getEmployees()) {
			totalVacationDays += employee.getVacationDays();
		}

		return totalVacationDays;
	}

	public double getTotalEmployeesPayTaxes() {
		double totalPayTaxes = 0;
		totalPayTaxes = getManager().getVacationDays();

		for (Employee employee : getEmployees()) {
			totalPayTaxes += employee.getTaxPay();
		}

		return totalPayTaxes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
