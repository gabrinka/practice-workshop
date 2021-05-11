package com.sap.intern.simplelibrary.test;

import java.io.File;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sap.intern.simplelibrary.implementations.Book;
import com.sap.intern.simplelibrary.implementations.NationalLibrary;
import com.sap.intern.simplelibrary.implementations.User;
import com.sap.intern.simplelibrary.implementations.interfaces.Library;

public class TestLibraryImplementation {
	private static final String LIBRARY_FILEPATH = "C:\\Users\\I539966\\eclipse-workspace\\SimpleLibrary\\src\\com\\sap\\intern\\simplelibrary\\test\\library.xml";
	private static String availableBook = "Pride and Prejudice";
	private static String unexistingBook = "Beauty And The Beast";

	public static void main(String[] args) throws JAXBException {
		Library library = null;
		try {
			library = createLibrary();
		} catch (JAXBException jbe) {
			System.out.println("Could not read books from file properly:" + jbe.getMessage());
			throw jbe;
		}

		User user = new User("Ivan");
		String bookToLend = unexistingBook;
		System.out.println(user.getName() + " wants to read " + bookToLend + '.');
		Optional<Book> book = library.lendBook(bookToLend);

		if (book.isPresent()) {
			Book bookToTake = book.get();
			user.takeBook(bookToTake);
			Book bookToReturn = user.returnTakenBook(bookToLend).get();
			library.returnBook(bookToReturn);
		}
		
	}

	private static Library createLibrary() throws JAXBException {
		File file = new File(LIBRARY_FILEPATH);
		JAXBContext jaxbContext = JAXBContext.newInstance(NationalLibrary.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Library library = (NationalLibrary) jaxbUnmarshaller.unmarshal(file);

		return library;
	}
}
