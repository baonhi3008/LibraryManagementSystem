package com.example.demo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Author;
import com.example.demo.entity.SubLibrary;
@Repository
public class AuthorDaoImpl implements AuthorDAO{
	
	
	private static final String NAME = "name";
	private static final String CREDITENTIAL = "creditential";
	
	private EntityManager entityManager;
    @Autowired
    public AuthorDaoImpl(EntityManager theEntityManager){entityManager = theEntityManager;}
    
    
    
	@Override
	@Transactional
	public void saveAuthor(Author author) {
		Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(author);
        
		if(author.getLibrary() != null ) {
			author.setLibrary(currentSession.get(SubLibrary.class,author.getLibrary().getId()));
		}
        currentSession.saveOrUpdate(author);
	}



	@Override
	@Transactional
	public List<Author> findByCriteria(String name, boolean descOrderingByName, String creditential,
			boolean descOrderingByCreditential) {
		
		Session currentSession = entityManager.unwrap(Session.class);
        Criteria criteria = currentSession.createCriteria(Author.class);
        if (name != null) {
        	//we do a like so it match the beginning of the subject
            criteria.add(Restrictions.like(NAME, name + "%"));
        }
        
        if (creditential != null) {
        	//we do a like so it match the beginning of the subject
            criteria.add(Restrictions.like(CREDITENTIAL, creditential + "%"));
        }
        
        if(descOrderingByName) {
        	 criteria.addOrder(Order.desc(NAME));
        }else {
        	//by default we order by subject
        	 criteria.addOrder(Order.asc(NAME));
        }
        
        if(descOrderingByCreditential) {
       	 criteria.addOrder(Order.desc(CREDITENTIAL));
       }else {
       	//by default we order by subject
       	 criteria.addOrder(Order.asc(CREDITENTIAL));
       }
        return criteria.list();
		
	}



	@Override
	@Transactional
	public void delete(Author author) {
		Session currentSession = entityManager.unwrap(Session.class);
       // currentSession.remove(author);
        currentSession.remove(currentSession.contains(author) ? author : currentSession.merge(author));

	}
    
  

}
