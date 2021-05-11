package com.sap.intern.task12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteAndReadObjectsFromFile {
	private static final String FILEPATH = "C:\\Users\\I539966\\eclipse-workspace\\Tasks\\src\\com\\sap\\intern\\task12\\usersData2.txt";
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Please input first user's data!");
		User firstUser = generateUserObject();
//TODO: split main logic into other methods,null checks
		System.out.println("Please input second user's data!");
		User secondUser = generateUserObject();

		try {
			writeUsersToFile(firstUser, secondUser, FILEPATH);
		} catch (IOException ioe) {
			System.out.println("Problem occurred during writing to file: " + ioe.getMessage());
		}

		try {
			List<User> users = readUsersFromFile(FILEPATH);
			for (User user : users) {
				System.out.println(user.getUserName() + " " + user.getEgn());
			}
		} catch (IOException ioe) {
			System.out.println("Problem occurred during reading from file: " + ioe.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("No definition for the class with the specified name could be found: " + cnfe.getMessage());
		}
	}

	private static List<User> readUsersFromFile(final String filePath) throws IOException, ClassNotFoundException {
		List<User> users = new ArrayList<>();

		try (FileInputStream fileInput = new FileInputStream(filePath);
				ObjectInputStream inputObjectStream = new ObjectInputStream(fileInput)) {

			User first = (User) inputObjectStream.readObject();
			users.add(first);

			User second = (User) inputObjectStream.readObject();
			users.add(second);
		}
		return users;
	}

	private static void writeUsersToFile(final User first,final User second,final String filePath) throws IOException {
		try (FileOutputStream outputStream = new FileOutputStream(filePath);
				ObjectOutputStream outputObjectStream = new ObjectOutputStream(outputStream)) {

			outputObjectStream.writeObject(first);
			outputObjectStream.writeObject(second);
		}
	}

	private static User generateUserObject() {
		System.out.print("Please input name and egn: ");
		String name = scanner.next();
		String egn = scanner.next();

		return new User(name, egn);

	}

}
