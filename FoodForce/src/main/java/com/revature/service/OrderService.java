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
	
	public Order getOrderById(int id) {	
		return orderDAO.getOrderById(id);
	}

	
	//delete order
	public Order cancelOrder(int orderid) {
		Order order = orderDAO.getOrderById(orderid);
		
		if(order.getStatus().equals("pending")) {
			order.setStatus("cancelled");
		}
		orderDAO.updateStatus(order);
		return order;
	}
	
	public List<Order> pendingOrders(){
		return orderDAO.pendingOrders();
	}
	
	public List<Order> acceptedOrdersByEmployee(int employeeId){
		return orderDAO.acceptedOrdersByEmployee(employeeId);
	}
	
	public List<Order> getOrderByStatus(String status){
		return orderDAO.getOrderByStatus(status);
	}
	

}
