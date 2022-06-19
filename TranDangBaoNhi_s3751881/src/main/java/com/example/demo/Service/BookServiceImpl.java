package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.AuthorDAO;
import com.example.demo.DAO.BookDAO;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDAO bookRepository;

	@Override
	public void saveBook(Book book) {
		bookRepository.saveBook(book);
		
	}

	@Override
	public void delete(Book book) {
		bookRepository.delete(book);
		
	}

	@Override
	public List<Book> findByCriteria(String name, Long dateOfCreation, boolean descOrderingByName,
			boolean descOrderingByCreditential) {
		return bookRepository.findByCriteria(name, dateOfCreation, descOrderingByName, descOrderingByCreditential );
	}

	
	
   
}
