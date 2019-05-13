package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDAO;

import com.revature.dao.CustomerDAOImpl;


@Service
public class CustomerService {

	// @Autowired
	// private CustomerDAO cdao;
	
	// @Autowired
	// public CustomerService(CustomerDAOImpl cd) {
	// 	this.cdao = cd;
	// }
	
//	public Customer getCustomerByCredentialId(int id) {
//		return cdao.getCustomerByCredentialId(id);
//		
//	}


	
	private CustomerDAO customerDAO;
	
	@Autowired
	public CustomerService(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	
	//get Customer by ID
	public Customer getCustomerById(int id) {
		return customerDAO.getCustomerById(id);
	}
	
	//get all customers
	public List<Customer> allCustomers(){
		return customerDAO.allCustomers();
	}
	
	// create a new customer
	public void createCustomer(Customer customer) {
		customerDAO.createCustomer(customer);
	}
	
	//update a customer
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}
	
	//delete a customer
	public void deleteCustomer(Customer customer) {
		customerDAO.deleteCustomer(customer);
	}

}
