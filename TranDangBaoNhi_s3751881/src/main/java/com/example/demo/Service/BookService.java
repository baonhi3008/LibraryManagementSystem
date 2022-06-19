package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Book;

public interface BookService {
	
	public void saveBook(Book book);


	public void delete(Book book);


	public List<Book> findByCriteria(String name, Long dateOfCreation, boolean descOrderingByName,
			boolean descOrderingByCreditential);

}
