package com.sap.intern.shapes.implementations;

import com.sap.intern.shapes.interfaces.Shape;

public class Circle implements Shape{
	private final static double PI = Math.PI;
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		double exponent = Math.pow(radius, 2);
		double area = PI * exponent;
		
		return area;
	}

	@Override
	public double calculatePerimeter() {
		double perimeter = 2 * PI * radius;
		
		return perimeter;
	}

}
