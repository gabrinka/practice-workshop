package com.sap.intern.shapes.implementations;

import com.sap.intern.shapes.interfaces.Shape;

public class Triangle implements Shape {
	private double a;
	private double b;
	private double c;
	private double height;

	public Triangle(double a, double b, double c, double height) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.height = height;
	}

	@Override
	public double calculateArea() {
		double triangleArea = a * b * (height / 2);
		return triangleArea;
	}

	@Override
	public double calculatePerimeter() {
		double trianglePerimeter = a + b + c;
		return trianglePerimeter;
	}

}
