package com.example.demo.request;

import com.example.demo.entity.Book;

public class BookRequest {
	private Book book;
	private Integer authorId;
	
	
	
	public BookRequest() {
		super();
	}
	public BookRequest(Book book, Integer authorId) {
		super();
		this.book = book;
		this.authorId = authorId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
}
