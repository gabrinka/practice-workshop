package com.sap.intern.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class OddNumbers {
	private final static int GENERATED_NUMBERS_COUNT = 10;
	
	private static Integer findBiggestOddNumber(final List<Integer> numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return null;
		}

		SortedSet<Integer> oddNumbers = new TreeSet<Integer>();

		for (int i = 0; i < numbers.size(); i++) {
			boolean isOddNumber = numbers.get(i) % 2 != 0;
			if (isOddNumber) {
				oddNumbers.add(numbers.get(i));
			}
		}

		if (oddNumbers.isEmpty()) {
			return null;
		}

		return oddNumbers.last();
	}

	public static void main(String[] args) {
		List<Integer> randomNumbers = generateListWithRandomNumbers();
		System.out.println("Generated numbers are:");
		randomNumbers.forEach(System.out::println);
		
		Integer biggestOddNumber = findBiggestOddNumber(randomNumbers);
		System.out.println("The biggest odd number is: " + biggestOddNumber);
	}

	private static List<Integer> generateListWithRandomNumbers() {

		List<Integer> numbers = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < GENERATED_NUMBERS_COUNT; i++) {

			numbers.add(random.nextInt());
		}
		return numbers;
	}

}
