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
	
	//fully functional
	@GetMapping(value = "/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
			Employee e = employeeService.getEmployeeById(id);
			if(e == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<>(e, HttpStatus.OK);
			}
	}
	
	//fully functional
	@GetMapping(value = "/all")
	public ResponseEntity<List<Employee>> allEmployees(){
		return new ResponseEntity<>(employeeService.allEmployees(), HttpStatus.OK);
	}
	
	//fully functional
	@PostMapping(value = "/create")
	public ResponseEntity<?> createEmployee(@RequestBody Employee empl){
		ResponseEntity<?> resp = null;
		try {
			employeeService.createEmployee(empl);
			resp = new ResponseEntity<>("Employee: " + empl + " created successfully!", HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to create" + empl + " as Employee",HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	//fully functional
	@PutMapping(value = "/update/{id}" )
	public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee empl){
		ResponseEntity<?> resp = null;
		try {
			employeeService.updateEmployee(id, empl);
			resp = new ResponseEntity<>("Employee " + empl.getFirstName() + " " + empl.getLastName() + " was updated succesfully",HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to update Employee", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	//fully functional
	@DeleteMapping(value = "/delete/{id}")
	public  ResponseEntity<String> deleteEmployee(@PathVariable int id){
		ResponseEntity<String> resp = null;
		try {
			employeeService.deleteEmployee(id);
			resp = new ResponseEntity<>("Employee with id: "+ id + " was deleted successfully!",HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to delete employee" , HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	//getEmployeeByCredentialId is missing
	
	


}
