package com.revature.dao;

import java.util.List;

import com.revature.entities.Order;

public interface OrderDAO {

	public Order createOrder(Order order);
	public List<Order> getCustomerOrders(int customerId);
	public List<Order> pendingOrders();
	public List<Order> acceptedOrdersByEmployee(int employeeId);
	public List<Order> getOrderByStatus(String status);
	public void changeStatus(int orderId, Order order);
	public Order cancelOrder(Order order);
	
	
	public void updateStatus(Order order);
	public Order getOrderById(int id);
	

	//Adding new methods May 12, 2019
	
	
	
	
}
