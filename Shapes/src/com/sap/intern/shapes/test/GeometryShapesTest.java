package com.sap.intern.shapes.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sap.intern.shapes.implementations.Circle;
import com.sap.intern.shapes.implementations.Rectangle;
import com.sap.intern.shapes.implementations.ShapeComparator;
import com.sap.intern.shapes.implementations.Square;
import com.sap.intern.shapes.implementations.Triangle;
import com.sap.intern.shapes.interfaces.Shape;

public class GeometryShapesTest {

	public static void main(String[] argv) {

		List<Shape> generatedShapes = new ArrayList<>();
		generatedShapes.add(new Circle(4.5));
		generatedShapes.add(new Circle(5.5));
		generatedShapes.add(new Rectangle(4, 5));
		generatedShapes.add(new Square(3));
		generatedShapes.add(new Triangle(1, 2, 3, 2));

		System.out.println("Sum of all shape areas: " + getSumOfAreas(generatedShapes));
		System.out.println("Sum of all perimeters: " + getSumOfPerimeters(generatedShapes));
		System.out.println("Sum of all circle shape perimeters: " + getSumOfPerimetersOfCircles(generatedShapes));

		Shape shapeWithBiggestArea = getShapeOfBiggestArea(generatedShapes);
		System.out.println("The shape with the biggest area is a " + shapeWithBiggestArea.getClass().getSimpleName()
				+ " and its area is: " + shapeWithBiggestArea.calculateArea());
	}

	private static double getSumOfAreas(final List<Shape> generatedShapes) {
		double sumOfAreas = 0;

		for (Shape shape : generatedShapes) {
			sumOfAreas += shape.calculateArea();
		}

		return sumOfAreas;
	}

	private static Shape getShapeOfBiggestArea(final List<Shape> generatedShapes) {
		int lastShapeIndex = generatedShapes.size() - 1;
		generatedShapes.sort(new ShapeComparator());
		Shape biggestAreaShape = generatedShapes.get(lastShapeIndex);

		return biggestAreaShape;

	}

	private static double getSumOfPerimeters(final List<Shape> generatedShapes) {
		double sumOfPerimeters = 0;

		for (Shape shape : generatedShapes) {
			sumOfPerimeters += shape.calculatePerimeter();
		}

		return sumOfPerimeters;
	}

	private static double getSumOfPerimetersOfCircles(final List<Shape> generatedShapes) {
		List<Shape> circles = generatedShapes.stream().filter(shape -> shape instanceof Circle)
				.collect(Collectors.toList());

		return getSumOfPerimeters(circles);
	}

}
