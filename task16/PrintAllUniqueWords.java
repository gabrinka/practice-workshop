package com.sap.intern.task16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrintAllUniqueWords {
	private static final String FILE_PATH = "C:\\Users\\I539966\\eclipse-workspace\\Tasks\\src\\com\\sap\\intern\\task16\\cats.txt";
	private static final String REGEX_WORDS_DELIMETER = "[., ]+";
	private static final String REGEX_NEW_LINE_DELIMETER = "\\n";
	private static Set<String> uniqueWords = new HashSet<>();

	public static void main(String[] args) throws IOException {
		String text;
		
		try {
			text = readFromFile(FILE_PATH);
			String[] linesFromText = text.split(REGEX_NEW_LINE_DELIMETER);

			System.out.println(Arrays.asList(linesFromText));

			for (String line : linesFromText) {

				addUniqueWordsToSet(line);
			}
			System.out.println("The unique words are:\n" + uniqueWords);
		} catch (IOException ioe) {
			System.out.println("Could not parse file poperly: " + ioe.getMessage());
			throw ioe;
		}
	}

	private static void addUniqueWordsToSet(final String line) {
		String[] words = line.split(REGEX_WORDS_DELIMETER);
		for (String currentWord : words) {
			uniqueWords.add(currentWord);
		}
	}

	private static String readFromFile(final String filePath) throws IOException {
		StringBuilder extractedFileContent = new StringBuilder();
		try (FileReader extractWords = new FileReader(filePath);
				BufferedReader textParser = new BufferedReader(extractWords)) {
			String readLine;
			
			while ((readLine = textParser.readLine()) != null) {
				extractedFileContent.append(readLine + '\n');
			}
		}
		return extractedFileContent.toString();
	}
}
