package com.sap.intern.task14;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class FileModificationUsingReaderWriter {
	private static Scanner scanner = new Scanner(System.in);
	private static final String FILEPATH = "C:\\Users\\I539966\\eclipse-workspace\\Tasks\\src\\com\\sap\\intern\\task14\\gabi99.txt";
	private static final String MODIFIED_FILEPATH = "C:\\Users\\I539966\\eclipse-workspace\\Tasks\\src\\com\\sap\\intern\\task14\\modified.txt";

	public static void main(String[] args) throws IOException {
		String modifiedFileContent = "";
		try {
			String fileContent = readFileContent(FILEPATH);
			modifiedFileContent = modifyFile(fileContent);
			saveNewContentInFile(MODIFIED_FILEPATH,modifiedFileContent);
		} catch (IOException ioe) {
			System.out.println("File could not be processed: " + ioe.getMessage());
			throw ioe;
		}
	}

	private static String modifyFile(final String fileContent) {
		System.out.println("Choose a word to replace another one in the file:");
		String wordToReplace = scanner.next();
		String newWordName = scanner.next();

		return fileContent.replaceAll(wordToReplace, newWordName);
	}

	private static void saveNewContentInFile(final String filePath,final String fileContent) throws IOException {
		try (Writer dataSaver = new FileWriter(filePath)) {
			dataSaver.write(fileContent);
		}
	}
//TODO: encoding best to be passed as argument,how to pass it
	private static String readFileContent(final String filepath) throws IOException {
		StringBuilder fileContent = new StringBuilder();

		try (Reader fileDataReader = new FileReader(filepath)) {
			int currentChar;

			while ((currentChar = fileDataReader.read()) != -1) {
				fileContent.append((char) currentChar);
			}
			return fileContent.toString();
		}
	}
}
