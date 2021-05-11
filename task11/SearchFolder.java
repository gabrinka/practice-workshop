package com.sap.intern.task11;

import java.io.File;

public class SearchFolder {
	private static final String ROOT_DIRECTORY = "C:\\\\Users\\\\I539966";
	private static final String FILE_TO_SEARCH = "myfile.txt";

	public static void main(String[] args) {

		File root = new File(ROOT_DIRECTORY);
		String absolutePathToFile = getAbsolutePathToFile(root, FILE_TO_SEARCH);

		if (absolutePathToFile == null) {
			System.out.println("File " + FILE_TO_SEARCH + " not found!");
		} else {
			System.out.println("Absolute path of the file is: " + absolutePathToFile);
		}
	}

	private static String getAbsolutePathToFile(final File rootDirectory, final String filenameToSearch) {
		if (rootDirectory == null || filenameToSearch == null) {
			System.out.println("Arguments cannot be null!");
			return null;
		}
		boolean isSearchedFile = rootDirectory.isFile() && filenameToSearch.equals(rootDirectory.getName());
		if (isSearchedFile) {
			return rootDirectory.getAbsolutePath();
		} else {
			File[] files = rootDirectory.listFiles();
			if (files == null) {
				return null;
			}
			for (File file : files) {
				String pathToFile = getAbsolutePathToFile(file, filenameToSearch);
				if (pathToFile != null) {
					return pathToFile;
				}
			}
		}
		return null;
	}
}
