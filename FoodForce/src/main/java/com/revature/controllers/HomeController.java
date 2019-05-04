package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private EmployeeDAO empDao;
	
	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/")
	public String home() {
		Employee e = empDao.getEmployeeById(1);
		System.out.println(e);
		return "home";
	}

}
