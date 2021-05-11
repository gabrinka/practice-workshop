package com.sap.intern.company.implementations;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import com.sap.intern.company.implementations.exception.DepartmentException;

public class Company {
	private String name;
	private Set<Department> departments;

	public Company(final String name) {

		this.name = name;
		this.departments = new HashSet<Department>();
	}

	public Set<Department> getDepartments() {
		return Collections.unmodifiableSet(departments);
	}

	public String getName() {
		return name;
	}

	public void addDepartment(final Department department) {
		departments.add(department);
	}

	public double getDepartmentPayTaxes(final String departmentName) throws DepartmentException {
		final Optional<Department> wantedDepartment = getDepartmentByName(departmentName);

		if (wantedDepartment.isPresent()) {
			return wantedDepartment.get().getTotalEmployeesPayTaxes();
		}
		throw new DepartmentException("Invalid department: " + departmentName);
	}

	public int getDepartmentVacationDays(final String departmentName) throws DepartmentException {
		final Optional<Department> wantedDepartment = getDepartmentByName(departmentName);

		if (wantedDepartment.isPresent()) {
			return wantedDepartment.get().getTotalEmployeesVacationDays();
		}
		throw new DepartmentException("Invalid department: " + departmentName);
	}

	public String getDepartmentManagerName(final String departmentName) throws DepartmentException {
		final Optional<Department> wantedDepartment = getDepartmentByName(departmentName);

		if (wantedDepartment.isPresent()) {
			final Employee wantedDepartmentManagaer = wantedDepartment.get().getManager();
			return wantedDepartmentManagaer.getName();
		}
		throw new DepartmentException("Invalid department: " + departmentName);
	}

	private Optional<Department> getDepartmentByName(final String departmentName) {
		Predicate<Department> isEqual = department -> department.getName().equals(departmentName);
		Optional<Department> foundDepartment = departments.stream().filter(isEqual).findFirst();

		return foundDepartment;
	}
}
