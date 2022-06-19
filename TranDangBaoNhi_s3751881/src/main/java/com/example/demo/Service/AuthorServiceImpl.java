package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.AuthorDAO;
import com.example.demo.entity.Author;
@Service
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	AuthorDAO authorRepository;

	@Override
	public void saveAuthor(Author author) {
		authorRepository.saveAuthor(author);
	}

	@Override
	public List<Author> findByCriteria(String name, boolean descOrderingByName, String creditential,
			boolean descOrderingByCreditential) {
		return authorRepository.findByCriteria(name, descOrderingByName, creditential, descOrderingByCreditential) ;
	}

	@Override
	public void delete(Author author) {
		authorRepository.delete(author);
	} 

	
   
}
