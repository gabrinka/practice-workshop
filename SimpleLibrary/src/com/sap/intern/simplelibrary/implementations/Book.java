package com.sap.intern.simplelibrary.implementations;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "book")
@XmlAccessorType (XmlAccessType.FIELD)
public class Book {
	private int yearOfPublishing;
	private long isbn;
	private String name;
	private String author;
	private String publisher;
	private String genre;

	public Book() {

	}

	public int getYearOfPublishing() {
		return yearOfPublishing;
	}

	public void setYearOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}


	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}


	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}


	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(final String publisher) {
		this.publisher = publisher;
	}


	public String getGenre() {
		return genre;
	}

	public void setGenre(final String genre) {
		this.genre = genre;
	}
}
