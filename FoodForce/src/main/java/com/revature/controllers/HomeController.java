package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.service.EmployeeService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private EmployeeService eserv;
	
//	public HomeController(EmployeeService eserv) {
//		this.eserv = eserv;
//	}
	
	@GetMapping("/")
	public String home() {
		Employee emp = eserv.getEmployeeById(1);
		System.out.println(emp);
		return "home";
	}
	
//	@GetMapping(value="/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
//		Employee emp = eserv.getEmployeeById(id);
//		if (emp == null) {
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//		} else {
//			return new ResponseEntity<>(emp, HttpStatus.OK);
//		}
//	}
//	
//	@GetMapping(value="/")
//	public ResponseEntity<List<Employee>> allEmployees() {
//		return new ResponseEntity<>(eserv.allEmployees(), HttpStatus.OK);
//	}

}
