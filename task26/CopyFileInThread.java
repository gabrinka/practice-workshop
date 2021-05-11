package com.sap.intern.task26;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileInThread extends Thread {
	private int number;
	private String fileSource;
	private String fileDestination;

	public CopyFileInThread(int number, final String fileSource, final String fileDestination) {
		if (fileDestination == null || fileSource == null) {
			throw new IllegalArgumentException("File paths cannot be null!");
		}

		this.number = number;
		this.fileSource = fileSource;
		this.fileDestination = fileDestination;
	}

	public void run() {
		try {
			copyFile(fileSource, fileDestination);
			System.out.println("Thread Number:" + number + " executed!");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Could not find the specified file: " + fnfe.getMessage());
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("Could not process files correctly: " + ioe.getMessage());
			ioe.printStackTrace();
		}
	}

	private void copyFile(final String fileSource, final String fileDestination)
			throws IOException, FileNotFoundException {
		try (FileInputStream inputFile = new FileInputStream(fileSource);
				FileOutputStream outputFile = new FileOutputStream(fileDestination)) {
			int i = 0;
			while ((i = inputFile.read()) != -1) {
				outputFile.write(i);
			}
		}
	}
}
