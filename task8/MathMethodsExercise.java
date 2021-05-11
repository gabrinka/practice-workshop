package com.sap.intern.task8;

import java.util.Scanner;

public class MathMethodsExercise {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Please input two numbers: ");
		double a = getInputNumber();
		double b = getInputNumber();

		System.out.println("Generated random number is: " + getRandomNumber());
		System.out.println("Minimum number between " + a + " and " + b + " is: " + getMinNumber(a, b));
		System.out.println("Maximum number between " + a + " and " + b + " is: " + getMaxNumber(a, b));
		System.out.println("Absolute value of " + a + " is: " + getAbsNumber(a));
		System.out.println("Rounded number of " + a + " is: " + getRoundNumber(a));
		System.out.println("Circle area of a circle with radius: " + b + " is: " + getCircleArea(b));
		System.out.println("Square root of " + a + " is: " + getSquareRoot(a));

	}

	private static double getInputNumber() {

		if (scanner.hasNextDouble()) {
			return scanner.nextDouble();
		} else {
			System.out.println("Invalid input");
			System.exit(0); //could use the made exception class 
		}

		return 0;
	}

	private static double getAbsNumber(double n) {
		return Math.abs(n);
	}

	private static double getRoundNumber(double n) {
		return Math.round(n);
	}

	private static double getMinNumber(double a, double b) {
		return Math.min(a, b);
	}

	private static double getMaxNumber(double a, double b) {
		return Math.max(a, b);
	}

	private static double getCircleArea(double radius) {
		double exponent = Math.pow(radius, 2);

		return Math.PI * exponent;
	}

	private static double getSquareRoot(double x) {
		if (x < 0) {
			System.out.println("Invalid input!");
			System.exit(0);
		}

		return Math.sqrt(x);
	}

	private static int getRandomNumber() {
		return (int) (Math.random() * 100);
	}

}
