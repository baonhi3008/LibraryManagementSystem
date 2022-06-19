package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    
    
    @Column
    private String creditential;
    
    
    @OneToMany(mappedBy = "author",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private List<Book> books;
    
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="library_id")
    private SubLibrary library;
    

	public SubLibrary getLibrary() {
		return library;
	}


	public void setLibrary(SubLibrary library) {
		this.library = library;
	}


	public Author() {
    	super();
    }
    
    
    public Author(int id, String name, String creditential, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.creditential = creditential;
		this.books = books;
	}

	public String getCreditential() {
		return creditential;
	}

	public void setCreditential(String creditential) {
		this.creditential = creditential;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

  
	

}
