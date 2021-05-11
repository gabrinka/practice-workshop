package com.sap.intern.simplelibrary.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class User {
	private String name;
	private List<Book> takenBooks;

	public User(final String name) {

		this.name = name;
		this.takenBooks = new ArrayList<>();

	}

	public String getName() {
		return name;
	}

	public Optional<Book> returnTakenBook(final String bookName) {
		Optional<Book> book = findBookByName(bookName);
		if (book.isPresent()) {
			System.out.println(name + " finished reading and  will return " + bookName + '.');
			takenBooks.remove(book);
		}
		return book;
	}

	public void takeBook(final Book bookToTake) {
		if (bookToTake == null) {
			System.out.println("Book cannot be null!");
		} else if (findBookByName(bookToTake.getName()).isPresent()) {
			System.out.println(name + " has already taken one copy of " + bookToTake.getName() + '.');
		} else {
			System.out.println(name + " will take " + bookToTake.getName() + '.');
			takenBooks.add(bookToTake);
		}
	}

	private Optional<Book> findBookByName(final String bookName) {
		Predicate<Book> isFound = book -> book.getName().equals(bookName);
		Optional<Book> book = takenBooks.stream().filter(isFound).findFirst();

		return book;
	}
}
