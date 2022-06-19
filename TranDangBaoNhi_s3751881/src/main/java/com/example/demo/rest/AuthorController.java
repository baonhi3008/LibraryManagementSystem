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

import com.example.demo.Service.AuthorService;
import com.example.demo.entity.Author;
import com.example.demo.entity.SubLibrary;
import com.example.demo.request.AuthorRequest;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/api/author")
public class AuthorController {

	@Autowired
	AuthorService authorService;



	@GetMapping("/search")
	public List<Author> findByCritria(@RequestParam(required= false) String name,
			@RequestParam(required= false) boolean descOrderingByName, String creditential,
			@RequestParam(required= false) boolean descOrderingByCreditential
			){

		return authorService.findByCriteria(name, descOrderingByName,  creditential, descOrderingByCreditential);

	}



	@PostMapping("/save")
	public String add(@RequestBody AuthorRequest request){
		
		if(request == null || request.getAuthor() == null) {
			return "wrong request";
		}
		
		if(request.getLibId() != null) {
			SubLibrary lib = new SubLibrary();
			lib.setId(request.getLibId());
			request.getAuthor().setLibrary(lib);
			
			
		}
		
		authorService.saveAuthor(request.getAuthor());
		return "save succesfully";
		
	}
	

	@PostMapping("/delete")
	public void delete(@RequestBody Author author){
		authorService.delete(author);
	}
	
	



}
