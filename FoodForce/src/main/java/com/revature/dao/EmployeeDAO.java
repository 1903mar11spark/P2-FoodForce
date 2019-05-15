package com.revature.dao;

import java.util.List;

import com.revature.entities.Employee;

public interface EmployeeDAO {
	
	public Employee getEmployeeById(int id);
	public List<Employee> allEmployees();
	public Employee createEmployee(Employee empl);
	public void updateEmployee(int id, Employee empl);
	public void deleteEmployee(int id);
	public Employee getEmployeeByCredentialId(int id);
	
	//new methods May 12, 2019
	
}
