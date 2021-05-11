package com.sap.intern.task2;

import java.util.Scanner;

public class TestPrintWithLoops {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Please input positive limit number:");
		int number = validInputCheck();

		System.out.print("Printing numbers from 0 to " + number + " using For loop :");
		printNumbersInRangeInForLoop(number);
		
		System.out.print("Printing numbers from 0 to " + number + " using While loop :");
		printRangeInWhileLoop(number);
		
		System.out.print("Printing numbers from 0 to " + number + " using Do-While loop :");
		printRangeInDoWhileLoop(number);
	}

	private static int validInputCheck() {
		if (scanner.hasNextInt()) {
			return scanner.nextInt();
		} else {
			System.out.println("Invalid input!");
			System.exit(0);
		}
		return 0;
	}

	private static void printRangeInDoWhileLoop(int number) {
		int i = 0;
		do {
			System.out.print(i + " ");
			i++;

		} while (i <= number);
		System.out.println();
	}

	private static void printRangeInWhileLoop(int number) {
		int i = 0;
		while (i <= number) {

			System.out.print(i + " ");
			i++;
		}
		System.out.println();
	}

	private static void printNumbersInRangeInForLoop(int number) {
		for (int i = 0; i <= number; i++) {

			System.out.print(i + " ");
		}
		System.out.println();
	}
}
