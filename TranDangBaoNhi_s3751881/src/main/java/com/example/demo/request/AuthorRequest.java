package com.example.demo.request;

import com.example.demo.entity.Author;

public class AuthorRequest {
	private Author author;
	private Integer libId;
	
	
	
	
	public AuthorRequest() {
		super();
	}
	public AuthorRequest(Author author, Integer libId) {
		super();
		this.author = author;
		this.libId = libId;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Integer getLibId() {
		return libId;
	}
	public void setLibId(Integer libId) {
		this.libId = libId;
	}
	
	
	
	
	
}
