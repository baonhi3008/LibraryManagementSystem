package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.BookService;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.request.BookRequest;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/api/book")
public class BookControler {

	@Autowired
	BookService bookservice;



	@GetMapping("/search")
	public List<Book> findByCritria(@RequestParam(required= false) String name,
			@RequestParam(name = "from", required= false) Long dateOfCreation,
			@RequestParam(required= false) boolean descOrderingByName,
			@RequestParam(required= false) boolean descOrderingByCreditential
			){


		return bookservice.findByCriteria(name, dateOfCreation, descOrderingByName, descOrderingByCreditential);

	}



	@PostMapping("/save")
	public String add(@RequestBody BookRequest bookRequest){
		
		if(bookRequest == null || bookRequest.getBook() == null) {
			return "Wrong request nothing was done";
		}
		
		if( bookRequest.getAuthorId() != null) {
			Author author = new Author();
			author.setId(bookRequest.getAuthorId());
			bookRequest.getBook().setAuthor(author);
		}
		
		bookservice.saveBook(bookRequest.getBook());
		return "successfully save";
	}


	@PostMapping("/delete")
	public void delete(@RequestBody Book book){
		bookservice.delete(book);
	}





}
