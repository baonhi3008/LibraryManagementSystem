package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.LibraryDAO;
import com.example.demo.entity.SubLibrary;
@Service
public class LibraryServicImpl implements LibraryService{
	
	@Autowired
	LibraryDAO libRepository; 

	@Override
	public void addLibrary(SubLibrary lib) {
		libRepository.addLibray(lib);
		
	}


	@Override
	public void update(SubLibrary lib) {
		libRepository.updateLibray(lib);
	}


	@Override
	public List<SubLibrary> findByCriteria(String subject, boolean descOrdering) {
		return libRepository.findByCriteria(subject, descOrdering);
	}

   
}
