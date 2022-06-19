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

import com.example.demo.Service.LibraryService;
import com.example.demo.entity.SubLibrary;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/api/library")
public class LibraryController {
	
	@Autowired
	LibraryService libraryService;
	
	
	
    @GetMapping("/search")
    public List<SubLibrary> findByCritria(@RequestParam(required= false) String subject,
    		@RequestParam(required= false) boolean descOrdering		){
    	
    	return libraryService.findByCriteria(subject, descOrdering );

    }
    
    
    
  @PostMapping("/save")
  public void add(@RequestBody SubLibrary library){
	  //this controler works for both insert and update
	  if(library.getId() == null) {
		  //we add
	  		libraryService.addLibrary(library);

	  }else {
		  libraryService.update(library);
	  }
  }
    
    
  
}
