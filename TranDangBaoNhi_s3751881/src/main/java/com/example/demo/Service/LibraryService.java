package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.SubLibrary;

public interface LibraryService {
	
	public void addLibrary(SubLibrary lib);
	public void update(SubLibrary lib);
	public List<SubLibrary> findByCriteria(String subject, boolean descOrdering);

}
