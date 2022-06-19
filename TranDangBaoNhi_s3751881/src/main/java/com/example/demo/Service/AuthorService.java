package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Author;

public interface AuthorService {
	
	public void saveAuthor(Author author);

	public List<Author> findByCriteria(String name, boolean descOrderingByName, String creditential,
			boolean descOrderingByCreditential);

	public void delete(Author author);

}
