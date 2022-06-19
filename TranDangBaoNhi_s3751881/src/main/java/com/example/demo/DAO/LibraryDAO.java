package com.example.demo.DAO;

import java.util.List;

import com.example.demo.entity.SubLibrary;

public interface LibraryDAO {
    public void addLibray(SubLibrary lib);
    public void updateLibray(SubLibrary lib);
	public List<SubLibrary> findByCriteria(String subject, boolean descOrdering);
}
