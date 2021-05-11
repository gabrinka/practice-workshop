package com.sap.intern.shapes.implementations;

import com.sap.intern.shapes.interfaces.Shape;

public class Square implements Shape {
	private static int SIDES_COUNT = 4;
	private double side;

	public Square(double side) {
		this.side = side;
	}

	@Override
	public double calculateArea() {
		double squareArea = side * side;
		return squareArea;
	}

	@Override
	public double calculatePerimeter() {
		double squarePerimeter = SIDES_COUNT * side;
		return squarePerimeter;
	}

}
