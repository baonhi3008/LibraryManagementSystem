package com.example.demo.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.SubLibrary;
@Repository
public class LibraryDAOImpl implements LibraryDAO{

	private EntityManager entityManager;
	@Autowired
	public LibraryDAOImpl(EntityManager theEntityManager){entityManager = theEntityManager;}



	@Transactional
	@Override
	public void addLibray(SubLibrary lib) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(lib);
	}


	@Transactional
	@Override
	public void updateLibray(SubLibrary lib) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(lib);
	}


	@Transactional
	@Override
	public List<SubLibrary> findByCriteria(String subject, boolean descOrdering) {
		Session currentSession = entityManager.unwrap(Session.class);
		Criteria criteria = currentSession.createCriteria(SubLibrary.class);
		if (subject != null) {
			//we do a like so it match the beginning of the subject
			criteria.add(Restrictions.like("subject", subject + "%"));
		}
		if(descOrdering) {
			criteria.addOrder(Order.desc("subject"));
		}else {
			//by default we order by subject
			criteria.addOrder(Order.asc("subject"));
		}
		return criteria.list();
	}




}
