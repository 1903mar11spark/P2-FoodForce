package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.OrderDAO;
import com.revature.entities.Order;

@Service
public class OrderService {
	
	private OrderDAO orderDAO;
	
	@Autowired
	public OrderService(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	//create order
	public Order createOrder(Order order) {
		return orderDAO.createOrder(order);
	}
	
	//get customer order with customer Id
	public List<Order> getCustomerOrders(int customerId){
		return orderDAO.getCustomerOrders(customerId);
	}
	
	//update status of order
	public void updateStatus(Order order) {
		orderDAO.updateStatus(order);
	}
	
//	//update total of order
//	public void updateTotal(Order order) {
//		orderDAO.updateTotal(order);
//	}
	
	//delete order
	public void deleteOrder(Order order) {
		orderDAO.deleteOrder(order);
	}
	
	public List<Order> pendingOrders(){
		return orderDAO.pendingOrders();
	}
	
	public List<Order> acceptedOrdersByEmployee(int employeeId){
		return orderDAO.acceptedOrdersByEmployee(employeeId);
	}
	

}
