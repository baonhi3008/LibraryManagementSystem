package com.example.demo.DAO;

import java.util.List;

import com.example.demo.entity.Author;

public interface AuthorDAO {
    public void saveAuthor(Author author);

	public List<Author> findByCriteria(String name, boolean descOrderingByName, String creditential,
			boolean descOrderingByCreditential);

	public void delete(Author author);
}
