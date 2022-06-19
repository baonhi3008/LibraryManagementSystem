package com.example.demo.DAO;

import java.util.Date;
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
import com.example.demo.entity.Book;
@Repository
public class BookDAOimpl implements BookDAO{
	
	
	private static final String NAME = "name";
	private static final String DATE_OF_CREATION = "dateOfCreation";
	
	private EntityManager entityManager;
    @Autowired
    public BookDAOimpl(EntityManager theEntityManager){entityManager = theEntityManager;}
    
    @Transactional
	@Override
	public void saveBook(Book book) {
		Session currentSession = entityManager.unwrap(Session.class);
		if(book.getAuthor() != null ) {
			book.setAuthor(currentSession.get(Author.class,book.getAuthor().getId()));
		}
        currentSession.saveOrUpdate(book);
		
	}
    
    @Transactional
	@Override
	public void delete(Book book) {
    	Session currentSession = entityManager.unwrap(Session.class);
         currentSession.remove(currentSession.contains(book) ? book : currentSession.merge(book));
		
	}

	@Override
	public List<Book> findByCriteria(String name, Long dateOfCreation, boolean descOrderingByName,
			boolean descOrderingByCreditential) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Criteria criteria = currentSession.createCriteria(Book.class);
		if (name != null) {
			//we do a like so it match the beginning of the subject
			criteria.add(Restrictions.like(NAME, name + "%"));
		}
		
		 if (dateOfCreation != null) {
	            criteria.add(Restrictions.gt(DATE_OF_CREATION, new Date(dateOfCreation)));
	     }
		
		
		if(descOrderingByName) {
			criteria.addOrder(Order.desc(NAME));
		}else {
			//by default we order by subject
			criteria.addOrder(Order.asc(NAME));
		}
		
		if(descOrderingByCreditential) {
			criteria.addOrder(Order.desc(DATE_OF_CREATION));
		}else {
			//by default we order by subject
			criteria.addOrder(Order.asc(DATE_OF_CREATION));
		}
		
		
		
		return criteria.list();
	}
    
    
    
    
  
    
  

}
