package com.revature.dao;

import java.util.List;

import com.revature.beans.Order;

public interface OrderDAO {

	public boolean createOrder(Order order);
	public List<Order> getCustomerOrders(int customerId);
	public Order updateStatus(Order order);
	public Order updateTotal(Order order);
	public Order deleteOrder(Order order);
	
	
}
