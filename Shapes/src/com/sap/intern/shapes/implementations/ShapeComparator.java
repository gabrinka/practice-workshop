package com.sap.intern.shapes.implementations;

import java.util.Comparator;

import com.sap.intern.shapes.interfaces.Shape;

public class ShapeComparator implements Comparator<Shape> {

	@Override
	public int compare(Shape first, Shape second) {
		return Double.compare(first.calculateArea(),second.calculateArea());
	}

}
