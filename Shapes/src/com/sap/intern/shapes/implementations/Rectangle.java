package com.sap.intern.shapes.implementations;

import com.sap.intern.shapes.interfaces.Shape;

public class Rectangle implements Shape {
	private static int SIDES_COUNT = 2;
	private double height;
	private double width;

	public Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}

	@Override
	public double calculateArea() {
		double rectangleArea = height * width;
		return rectangleArea;
	}

	@Override
	public double calculatePerimeter() {
		double rectanglePerimeter = SIDES_COUNT * (height + width);
		return rectanglePerimeter;
	}
}
