package com.revature.dao;


import com.revature.entities.Customer;

import java.util.List;



public interface CustomerDAO {

	public Customer getCustomerById(int id);
	public List<Customer> allCustomers();
	public void createCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	

	public Customer getCustomerByCredentialId(int id);
	Customer getCustomerByCredentials(String username, String password);
	



}
