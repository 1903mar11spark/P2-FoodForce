package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.beans.Customer;

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

}
