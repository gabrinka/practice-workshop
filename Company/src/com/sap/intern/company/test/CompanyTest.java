package com.sap.intern.company.test;

import java.util.Arrays;
import java.util.List;

import com.sap.intern.company.implementations.Company;
import com.sap.intern.company.implementations.Department;
import com.sap.intern.company.implementations.Employee;
import com.sap.intern.company.implementations.FullTimeEmployee;
import com.sap.intern.company.implementations.PartTimeEmployee;
import com.sap.intern.company.implementations.exception.DepartmentException;

public class CompanyTest {
	public static void main(String[] args) throws DepartmentException {

		Department hr = createHrDepartment();
		Department finance = createFinanceDepartment();
		
		Company company = new Company("My Company");
		company.addDepartment(finance);
		company.addDepartment(hr);
		
		try {
			System.out.println("Manager of finance department is: " + company.getDepartmentManagerName("Nonexisting department"));
			System.out.println("Total pay taxes are: " + company.getDepartmentPayTaxes("Finance"));
			System.out.println("Total vacation days are: " + company.getDepartmentVacationDays("Finance"));
		} catch (DepartmentException de) {
			System.out.println(de.getMessage() + " in our company " + company.getName());
			throw de;
		}
	}
	

	private static Department createHrDepartment() {
		List<Employee> hrDepartmentEmployees = Arrays.asList(new FullTimeEmployee("Ivan", "ivan@mail.bg", 200.05),
				new FullTimeEmployee("Ivana", "ivana@mail.bg", 200), new PartTimeEmployee("Kolio", "kolio@mail.bg"),
				new PartTimeEmployee("Mimi", "mimi@mail.bg"));

		Employee hrDepartmentManager = new FullTimeEmployee("Petya", "petya@mail.bg", 350);
		Department hrDepartment = new Department(hrDepartmentManager, "Human Resources", hrDepartmentEmployees);

		return hrDepartment;
	}

	private static Department createFinanceDepartment() {
		List<Employee> financeDepartmentEmployees = Arrays.asList(new FullTimeEmployee("Mariq", "mariq@mail.bg", 200),
				new FullTimeEmployee("Petur", "petur@mail.bg", 200), new FullTimeEmployee("Ani", "ani@mail.bg", 134.67),
				new PartTimeEmployee("Alex", "alex@mail.bg"));

		Employee financeDepartmentManager = new FullTimeEmployee("Kris", "kris@mail.bg", 400);
		Department financeDepartment = new Department(financeDepartmentManager, "Finance", financeDepartmentEmployees);

		return financeDepartment;
	}

}
