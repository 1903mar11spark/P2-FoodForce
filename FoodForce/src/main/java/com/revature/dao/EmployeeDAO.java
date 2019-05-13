package com.revature.dao;

import java.util.List;

import com.revature.entities.Employee;

public interface EmployeeDAO {
	
	public Employee getEmployeeById(int id);
	public List<Employee> allEmployees();
	public Employee createEmployee(Employee empl);
	public void updateEmployee(Employee empl);
	public void deleteEmployee(Employee empl);
	public Employee getEmployeeByCredentialId(int id);
	
	//new methods May 12, 2019
	
}
