package com.sap.intern.task6;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class StringSearchAndManipulation {
	private static final String DELIMETER = " ";

	public static void main(String[] args) throws InputException {

		String exampleText = "Amanda met Amy on an American Airlines flight";

		String replacedAChars = exampleText.replaceAll("A", "AA");
		System.out.println(replacedAChars);

		String[] splitIntoWords = splitStringByEmptySpace(exampleText);
		System.out.println(Arrays.toString(splitIntoWords));

		try {
			long symbolCount = findCharCount(null, 'A');
			System.out.println(symbolCount);

			String reversedText = reverseText(exampleText);
			System.out.println(reversedText);
		} catch (InputException ie) {
			System.out.println("Could not parse text properly:" + ie.getMessage());
			throw ie;
		}

	}

	private static long findCharCount(final String text, char symbolToSearch) throws InputException {
		if (text == null) {
			throw new InputException("Invalid input!");
		}
		IntPredicate findSymbol = ch -> ch == symbolToSearch;

		return text.chars().filter(findSymbol).count();
	}

	private static String reverseText(final String text) throws InputException {
		if (text == null) {
			throw new InputException("Invalid input!");
			// TODO: create an exception to be caught in main method and handled,could split
			// reverseText into 2
			// methods-validation and reverse OR combine them
		}

		StringBuilder reversedText = new StringBuilder(text).reverse();

		return reversedText.toString();
	}

	private static String[] splitStringByEmptySpace(final String example) {

		return example.split(DELIMETER);
	}

}
