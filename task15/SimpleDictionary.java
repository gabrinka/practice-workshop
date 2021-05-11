package com.sap.intern.task15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleDictionary {
	private static final String DICTIONARY_PATH = "C:\\Users\\I539966\\eclipse-workspace\\Tasks\\src\\com\\sap\\intern\\task15\\dictionary.txt";
	private static final String PAIRS_DELIMETER = "\\n";
	private static final String TRANSLATION_PAIR_DELIMETER = ", ";
	private static final String QUIT_SYMBOL = "0";
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		Map<String, String> dictionary = null;
		try {
			dictionary = initializeDictionary(DICTIONARY_PATH);
		} catch (IOException ioe) {
			System.out.println("Cannot read from dictionary file correctly: " + ioe.getMessage());
			throw ioe;
		}
		
		translate(dictionary);
	}

	private static void translate(final Map<String, String> dictionary) {
		System.out.println("Type a word you want to be translated,0 if you want to quit the application:");
		String originalWord = "";
		while (!originalWord.equals(QUIT_SYMBOL)) {
			originalWord = scanner.next();
			if (isValid(originalWord)) {
				String translatedWord = getTranslatedWord(dictionary, originalWord);
				System.out.println("Translated word is: " + translatedWord);
			} else {
				System.out.println("Invalid word!");
			}
		}
	}

	private static String getTranslatedWord(final Map<String, String> dictionary, final String originalWord) {
		String translatedWord = dictionary.get(originalWord);
		if (!isValid(translatedWord)) {
			translatedWord = "No such word in our simple dictionary!";
			return translatedWord;
		}
		return translatedWord;

	}

	private static boolean isValid(String word) {
		return word != null && !word.isEmpty();
	}

	private static Map<String, String> initializeDictionary(final String dictionaryPath) throws IOException {
		Map<String, String> dictionary = new HashMap<>();
		String dictionaryText;
		dictionaryText = readFromFile(dictionaryPath);
		dictionary = fillDictionaryWithWords(dictionaryText);

		return dictionary;
	}

	private static Map<String, String> fillDictionaryWithWords(final String dictionaryText) {
		String[] translationPairs = dictionaryText.split(PAIRS_DELIMETER);
		Map<String, String> dictionary = new HashMap<>();

		for (String currentPair : translationPairs) {
			String[] currentPairAsArray = currentPair.split(TRANSLATION_PAIR_DELIMETER);
			String englishWord = currentPairAsArray[0];
			String bulgarianWord = currentPairAsArray[1];

			dictionary.put(englishWord, bulgarianWord);
		}
		return dictionary;
	}

	private static String readFromFile(final String dictionaryPath) throws IOException {
		StringBuilder fileContent = new StringBuilder();
		try (FileReader extractWords = new FileReader(dictionaryPath);
				BufferedReader textParser = new BufferedReader(extractWords)) {
			String readLine;
			while ((readLine = textParser.readLine()) != null) {
				fileContent.append(readLine + '\n');
			}

			return fileContent.toString();
		}
	}
}
