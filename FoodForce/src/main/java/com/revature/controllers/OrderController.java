package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Order;
import com.revature.service.OrderService;

@RestController //combines Controller and Request Body
@RequestMapping(value = "/order")
public class OrderController {
	
	
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//Create an new order, returns string message
	@PostMapping
	public ResponseEntity<String> createOrder(@RequestBody Order order){
		ResponseEntity<String> resp = null;
		//calling the orderService class to create a new order
		try {
			orderService.createOrder(order);
			resp = new ResponseEntity<>("Order created successfully" , HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to create order" , HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	
	//get customer orders with customer id, returns list if not null
	@GetMapping(value = "/{customerId}")
	public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable int customerId){
		List<Order> order = orderService.getCustomerOrders(customerId);
		if(order == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}else
			return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	//Update status, returns string message
	public ResponseEntity<String> updateStatus(@RequestBody Order order){
		ResponseEntity<String> resp = null;
		
		try {
			orderService.updateStatus(order);
			resp = new ResponseEntity<>("Order updated successfully",HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to update order",HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}
	
	
	
	
	

}
