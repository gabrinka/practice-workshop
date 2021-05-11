package com.sap.intern.simplelibrary.implementations.interfaces;

import java.util.Optional;

import com.sap.intern.simplelibrary.implementations.Book;

public interface Library {
	boolean addBook(final Book book);
	Optional<Book> lendBook(final String bookName);
	boolean returnBook(final Book book);
	boolean containsBook(final String bookName);
	String getLibraryName();

}
