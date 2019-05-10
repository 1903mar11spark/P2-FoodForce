package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

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
	
	public void createEmployee(Employee empl) {
		edao.createEmployee(empl);
	}
	
	public void updateEmployee(Employee empl) {
		edao.updateEmployee(empl);
	}
	
	public void deleteEmployee(Employee empl) {
		edao.deleteEmployee(empl);
	}
	
	
}
