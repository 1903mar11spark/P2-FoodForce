package com.revature.dao;

import com.revature.beans.Customer;

public interface CustomerDAO {

	
	public Customer getCustomerByCredentials(String username, String password);
	
	public Customer getCustomerById(int id);


}
