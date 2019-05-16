package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Customer;
import com.revature.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	//fully functional
	@GetMapping(value = "/get-by-id/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId){
		Customer customer = customerService.getCustomerById(customerId);
		if(customer == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Customer>> allCustomers(){
		return new ResponseEntity<>(customerService.allCustomers(),HttpStatus.OK);
	}
	
	
	
}


