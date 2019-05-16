package com.revature.dao;

import java.util.List;

import com.revature.entities.Order;

public interface OrderDAO {

	public Order createOrder(Order order);
	public List<Order> getCustomerOrders(int customerId);
	public void updateStatus(Order order);
//	public void updateTotal(Order order);
//	public Order deleteO(int orderid);
	public Order cancelOrder(Order order);
	public Order getOrderById(int id);


	//Adding new methods May 12, 2019
	public List<Order> pendingOrders();
	public List<Order> acceptedOrdersByEmployee(int employeeId);
	public List<Order> getOrderByStatus(String status);
	
}
