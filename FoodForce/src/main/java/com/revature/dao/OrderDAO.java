package com.revature.dao;

import java.util.List;

import com.revature.beans.Order;

public interface OrderDAO {

	public boolean createOrder(float total, int customerId, int employeeId);
	public List<Order> getCustomerOrders(int customerId);
	public Order updateStatus(int orderId, String status);
	public Order updateTotal(int orderId, float total);
	
	
}
