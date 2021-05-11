package com.sap.intern.task7;

import java.util.Scanner;

public class StringConcatenation {
	private static final String DELIMETER = ", ";
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int inputNumber = getInputNumberFromConsole();

		String resultFromStringAppending = stringAppending(inputNumber);
		System.out.println(resultFromStringAppending);

		String resultFromStringBuilderAppending = stringBuilderAppending(inputNumber);
		System.out.println(resultFromStringBuilderAppending);
	}

	private static int getInputNumberFromConsole() {
		int inputNumber = 0;

		System.out.println("Please input a positive integer: ");
		if (scanner.hasNextInt()) {

			inputNumber = scanner.nextInt();
		} else {
			System.out.println("Invalid input");
		}
		return inputNumber;
	}

	private static String stringAppending(int number) {
		long startTime = System.currentTimeMillis();

		String resultString = "The numbers from 0-" + number + " are: 0";

		for (int i = 1; i <= number; i++) {
			resultString += ", " + i;
		}

		long executionTime = System.currentTimeMillis() - startTime;
		System.out.println("Time taken by String Concatenations: " + executionTime + "ms");

		return resultString;
	}

	private static String stringBuilderAppending(int number) {
		long startTime = System.currentTimeMillis();

		StringBuilder result = new StringBuilder();
		result.append("The numbers from 0-" + number + " are: 0");

		for (int i = 1; i <= number; i++) {

			result.append(DELIMETER).append(i);
		}

		long executionTime = System.currentTimeMillis() - startTime;
		System.out.println("Time taken by StringBuilder: " + executionTime + "ms");

		return result.toString();
	}
}
