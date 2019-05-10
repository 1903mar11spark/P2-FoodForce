package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO edao;
	
	//Should it be EmployeeDAO instead of EmployeeDAOImpl below on the datatype declaration?
	@Autowired
	public EmployeeService(EmployeeDAOImpl ed) {
		this.edao = ed;
	}

	public Employee getEmployeeById(int id) {
		return edao.getEmployeeById(id);
		
	}
	
	public List<Employee> allEmployees() {
		return edao.allEmployees();
	}
	
	public Employee createEmployee(Employee empl) {
		return edao.createEmployee(empl);
	}
	
	public Employee getEmployeeByCredentialId(int id) {
		return edao.getEmployeeById(id);
		
	}
	
	public void updateEmployee(Employee empl) {
		edao.updateEmployee(empl);
	}
	
	public void deleteEmployee(Employee empl) {
		edao.deleteEmployee(empl);
	}
	
	
}
