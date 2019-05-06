package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

@Service
public class EmployeeService {

	private EmployeeDAO edao;
	
	@Autowired
	public EmployeeService(EmployeeDAOImpl ed) {
		this.edao = ed;
	}

//	public Employee getEmployeeById(int id) {
//		return edao.getEmployeeById(id);
//		
//	}
	
	public List<Employee> allEmployees() {
		return edao.allEmployees();
	}
}
