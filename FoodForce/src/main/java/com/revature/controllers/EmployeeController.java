package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Employee;
import com.revature.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService eserv) {
		this.employeeService = eserv;
	}
	
//	@GetMapping(value="/employee/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
//		Employee emp = employeeService.getEmployeeById(id);
//		if (emp == null) {
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//		} else {
//			return new ResponseEntity<>(emp, HttpStatus.OK);
//		}
//	}
	
	@PostMapping("/newemployee")
	  Employee createEmployee(@RequestBody Employee newEmployee) {
	    return employeeService.createEmployee(newEmployee);
	  }

}
