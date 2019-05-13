package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Customer;


@RestController
@Controller
@RequestMapping("/customer")
public class CustomerController {
	
@GetMapping
	public List<Customer> getAllCustomers() {
		List<Customer> custList = new ArrayList<>(); 
		return custList;
	}
@PostMapping
@ResponseStatus(HttpStatus.OK)
public void createCustomer(@RequestBody Customer customer) {
}

@GetMapping("/{id}")
public Customer get(@PathVariable("id") int id) {
	return new Customer();
	
}




	//end points for Jackson json go here to link angular to java.  Youtube it. 

}
