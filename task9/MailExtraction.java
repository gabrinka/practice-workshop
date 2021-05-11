package com.sap.intern.task9;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MailExtraction {
	private static final String REGEX_FOR_EMAIL = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
	private static final String REGEX_DELIMETER = ",";
	private static final String FILEPATH = "C:\\Users\\I539966\\eclipse-workspace\\Tasks\\src\\com\\sap\\intern\\task9\\myfile.txt";

	public static void main(String[] args) throws IOException {

		// String exampleEmails ="alajasdsadhdha,cat@gmail.com,one@abvg,@gmail.com,alabala@mail.bg,kajkdj@.kajd@nh";
		//List<String> emails = Arrays.asList(exampleEmails.split(","));
		//List<String> validEmails = getOnlyValidEmails(emails);
		//validEmails.forEach(email -> System.out.println(email));

		String exampleEmailsFromFile;
		try {
			exampleEmailsFromFile = readFromFile(FILEPATH);
			List<String> emails = Arrays.asList(exampleEmailsFromFile.split(REGEX_DELIMETER));
			List<String> validEmails = getOnlyValidEmails(emails);
			validEmails.forEach(email -> System.out.println(email));
			
		} catch (IOException ioe) {
			System.err.println("Could not read from file properly: " + ioe.getMessage());
			throw ioe;
		}
	}

	private static String readFromFile(final String filePath) throws IOException{
		StringBuilder fileContent = new StringBuilder();
		FileReader fileReader = new FileReader(filePath);
		int currentChar;
		while ((currentChar = fileReader.read()) != -1) {
			fileContent.append((char) currentChar);
		}
		fileReader.close();

		return fileContent.toString();
	}

	private static List<String> getOnlyValidEmails(final List<String> emails) {
		List<String> validEmails = new ArrayList<>();

		Pattern validEmailPattern = Pattern.compile(REGEX_FOR_EMAIL);
		for (String email : emails) {
			boolean isValidEmail = validEmailPattern.matcher(email).matches();
			if (isValidEmail) {
				validEmails.add(email);
			}
		}
		return validEmails;
	}

	private static List<String> getOnlyValidEmailsUsingJava8(final List<String> emails) {
		Predicate<String> predicate = email -> Pattern.matches(REGEX_FOR_EMAIL, email);

		return emails.stream().filter(predicate).collect(Collectors.toList());
	}
}
