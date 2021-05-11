package com.sap.intern.task5;

import java.util.Scanner;

class SimpleCalculator {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Please input first number:");
		double firstNumber = scanner.nextDouble();

		System.out.println("Please input second number:");
		double secondNumber = scanner.nextDouble();

		System.out.println("Please input operation - 1 is for adding, 2-substracting, 3 - multiplying, 4 -dividing:");
		int command = scanner.nextInt();

		switch (command) {
		case 1:
			printAddedNumbers(firstNumber, secondNumber);
			break;
		case 2:
			printSubstractedNumbers(firstNumber, secondNumber);
			break;
		case 3:
			printMultipliedNumbers(firstNumber, secondNumber);
			break;
		case 4:
			printDividedNumbers(firstNumber, secondNumber);
			break;
		default:
			System.out.println("Invalid command!");

		}
	}

	private static void printDividedNumbers(double firstNumber, double secondNumber) {
		if (secondNumber != 0) {
			double result = firstNumber / secondNumber;
			System.out.println(result);
		} else {
			System.out.println("Cannot divide by 0!");
		}
	}

	private static void printMultipliedNumbers(double firstNumber, double secondNumber) {
		double result = firstNumber * secondNumber;
		System.out.println(result);
	}

	private static void printSubstractedNumbers(double firstNumber, double secondNumber) {
		double result = firstNumber - secondNumber;
		System.out.println(result);
	}

	private static void printAddedNumbers(double firstNumber, double secondNumber) {
		double result = firstNumber + secondNumber;
		System.out.println(result);
	}
}