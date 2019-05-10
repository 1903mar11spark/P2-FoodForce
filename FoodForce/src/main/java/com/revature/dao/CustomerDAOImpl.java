package com.revature.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.entities.Customer;
import com.revature.entities.Employee;

@Repository
@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
public class CustomerDAOImpl implements CustomerDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Customer getCustomerById(int id) {
		return sessionFactory.getCurrentSession().byId(Customer.class).getReference(id);
	}

	@Override
	public Customer getCustomerByCredentials(String username, String password) {
		return null;
	}
	
	//trying to merge

	@Override
	public Customer getCustomerByCredentialId(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
			Root<Customer> root = query.from(Customer.class);
	        query.select(root).where(builder.equal(root.get("credential.credentialid"), id));
	        
	        Query<Customer> q = session.createQuery(query);
	        Customer c = q.getSingleResult();
	        return c;	
	        
			} catch (Exception e) {
		         
		         return null;
			}
		}
	
	
	}


