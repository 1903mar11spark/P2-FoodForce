package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Customer;
import com.revature.entities.Food;
import com.revature.entities.Order;
import com.revature.service.CustomerService;
import com.revature.service.FoodService;
import com.revature.service.OrderService;


@RestController //combines Controller and Request Body.
@CrossOrigin
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService cserv;
	
	@Autowired
	private FoodService fserv;

	
	//fully functional
	@PostMapping(value = "/{customerId}")
	public ResponseEntity<String> createOrder(@PathVariable int customerId, @RequestBody Order order){
		Customer c = cserv.getCustomerById(customerId);
		ResponseEntity<String> resp = null;
		//calling the orderService class to create a new order
		try {
			order.setCustomer(c);
			if (order.getFood() != null) {
				for (Food f: order.getFood()) {
					Food fFromDB = fserv.getFoodById(f.getId());
					if (fFromDB != null) {
						f.setDescription(fFromDB.getDescription());
						f.setName(fFromDB.getName());
						f.setType(fFromDB.getType());
					}
				}
			}
			orderService.createOrder(order);
			resp = new ResponseEntity<>("Order created successfully" , HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to create order" , HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	//fully functional
	//get customer orders with customer id, returns list if not null
	@GetMapping(value = "/{customerId}")
	public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable int customerId){
		List<Order> orders = orderService.getCustomerOrders(customerId);
		if(orders == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		} else {
			for(Order o: orders) {
				o.setCustomer(null);
				o.setEmployee(null);
			}
			return new ResponseEntity<>(orders,HttpStatus.OK);
		}
	}
	
	//fully functional
	//show pending orders
	@GetMapping(value = "/pending")
	public ResponseEntity<List<Order>> pendingOrders() {
		return new ResponseEntity<>(orderService.pendingOrders(),HttpStatus.OK);
	}
	
	//fully functional
	//show accepted orders by Employee
	@GetMapping(value = "/accepted/{employeeId}")
	public ResponseEntity<List<Order>> acceptedOrdersByEmployee(@PathVariable int employeeId){
		return new ResponseEntity<>(orderService.acceptedOrdersByEmployee(employeeId),HttpStatus.OK);
	}
	
	//fully functional
	@GetMapping(value = "/get-by-status/{status}")
		public ResponseEntity<List<Order>> getOrderBystatus(@PathVariable String status){
		return new ResponseEntity<>(orderService.getOrderByStatus(status),HttpStatus.OK);
	}
	
	
	//Update status, returns string message
	@PutMapping("/update/{orderId}")
	public ResponseEntity<String> updateStatus(@RequestBody Order order){
		ResponseEntity<String> resp = null;
		Order o = new Order();
		try {
			orderService.updateStatus(order);			
			resp = new ResponseEntity<>("Order updated successfully",HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to update order",HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}
	
//	@PutMapping
//	public ResponseEntity<String> updateTotal(@RequestBody Order order){
//		ResponseEntity<String> resp = null;
//		try {
//			orderService.updateTotal(order);
//			resp = new ResponseEntity<>("Total has been updated!", HttpStatus.OK);
//		}catch(Exception e) {
//			resp = new ResponseEntity<>("Failed to update order",HttpStatus.BAD_REQUEST);
//		}
//		return resp;
//	}
//	
	@DeleteMapping(value = "/delete/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable int orderId){
		ResponseEntity<String> resp = null;
		try {
			orderService.cancelOrder(orderId);
			resp = new ResponseEntity<>("Order has been cancelled!", HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Order failed to cancel", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	
}
