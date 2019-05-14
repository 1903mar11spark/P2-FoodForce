package com.revature.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Employee;
import com.revature.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping(value = "/employee")
public class EmployeeController {
	

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
			Employee e = employeeService.getEmployeeById(id);
			if(e == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<>(e, HttpStatus.OK);
			}
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Employee>> allEmployees(){
		return new ResponseEntity<>(employeeService.allEmployees(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createEmployee(@RequestBody Employee empl){
		ResponseEntity<String> resp = null;
		try {
			employeeService.createEmployee(empl);
			resp = new ResponseEntity<>("Employee created successfully!", HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to create Employee",HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@PutMapping
	public ResponseEntity<String> updateEmployee(@RequestBody Employee empl){
		ResponseEntity<String> resp = null;
		try {
			employeeService.updateEmployee(empl);
			resp = new ResponseEntity<>("Employee updated succesfully",HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to update Employee", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	


}
