package com.sap.intern.task13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyUsingStreams {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		System.out.println("Please input a source filepath:");
		String fileSource = scanner.next();

		System.out.println("Please input a destination filepath:");
		String fileDestination = scanner.next();

		try{
			copyFileUsingStreams(fileSource, fileDestination);
		}
		catch(IOException ioe) {
			System.out.println("File could not be processed correctly: " + ioe.getMessage());
			throw ioe;
		}
	}
//java.nio read
	private static void copyFileUsingStreams(final String fileSource,final String fileDestination) throws IOException{
		try (FileInputStream inputFile = new FileInputStream(fileSource);
				FileOutputStream outputFile = new FileOutputStream(fileDestination)) {
			int i = 0;
			while ((i = inputFile.read()) != -1) {
				outputFile.write(i);
			}
		} 
	}
}
