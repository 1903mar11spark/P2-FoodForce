package com.revature.dao;

import java.util.List;

import com.revature.entities.Order;

public interface OrderDAO {

	public Order createOrder(Order order);
	public List<Order> getCustomerOrders(int customerId);
	public void updateStatus(Order order);
//	public void updateTotal(Order order);
	public void deleteOrder(Order order);
	
	
}
