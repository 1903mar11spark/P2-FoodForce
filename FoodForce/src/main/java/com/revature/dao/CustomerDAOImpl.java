package com.revature.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;
import com.revature.beans.Employee;

@Repository
@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
public class CustomerDAOImpl implements CustomerDAO {
	
	private SessionFactory sessionFactory;


	
	public Customer getCustomerById(int id) {
		return sessionFactory.getCurrentSession().get(Customer.class, id);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> allCustomers() {
		List<Customer> customers = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		customers = s.createQuery("from Customer").getResultList();
		return customers;
	}

	@Override
	public void createCustomer(Customer customer) {
		sessionFactory.getCurrentSession().persist(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		sessionFactory.getCurrentSession().delete(customer);
		
	}

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


