package com.sap.intern.simplelibrary.implementations;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sap.intern.simplelibrary.implementations.interfaces.Library;

@XmlRootElement(name = "library")
@XmlAccessorType(XmlAccessType.FIELD)
public class NationalLibrary implements Library {

	private String libraryName;

	private Map<Book, Integer> bookCatalog = new HashMap<>();

	@Override
	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(final String libraryName) {
		this.libraryName = libraryName;
	}

	public Map<Book, Integer> getBookCatalg() {
		return Collections.unmodifiableMap(bookCatalog);
	}

	public void setBookCatalog(final Map<Book, Integer> bookCatalog) {
		this.bookCatalog = bookCatalog;
	}

	@Override
	public boolean addBook(final Book book) {
		if (book == null) {
			return false;
		}

		int booksQuantity = 1;
		if (bookCatalog.containsKey(book)) {
			booksQuantity += bookCatalog.get(book);
		}

		bookCatalog.put(book, booksQuantity);
		return true;
	}

	@Override
	public Optional<Book> lendBook(final String bookName) {
		Optional<Book> bookToLend = findBookByName(bookName);
		if (bookToLend.isPresent()) {
			Book toLend = bookToLend.get();
			int bookQuantity = bookCatalog.get(toLend);
			bookQuantity--;

			if (bookQuantity == 0) {
				bookCatalog.remove(toLend);
			} else {
				bookCatalog.replace(toLend, bookQuantity);
			}
		}
		return bookToLend;
	}

	@Override
	public boolean returnBook(final Book book) {
		return addBook(book);
	}

	@Override
	public boolean containsBook(final String bookName) {
		Optional<Book> book = findBookByName(bookName);

		return book.isPresent();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookCatalog == null) ? 0 : bookCatalog.hashCode());
		result = prime * result + ((libraryName == null) ? 0 : libraryName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;
		NationalLibrary other = (NationalLibrary) object;
		if (bookCatalog == null) {
			if (other.bookCatalog != null)
				return false;
		} else if (!bookCatalog.equals(other.bookCatalog))
			return false;
		if (libraryName == null) {
			if (other.libraryName != null)
				return false;
		} else if (!libraryName.equals(other.libraryName))
			return false;
		return true;
	}

	private Optional<Book> findBookByName(final String bookName) {
		Predicate<Book> isContainded = book -> book.getName().equals(bookName);
		Optional<Book> foundBook = bookCatalog.keySet().stream().filter(isContainded).findFirst();

		return foundBook;
	}
}
