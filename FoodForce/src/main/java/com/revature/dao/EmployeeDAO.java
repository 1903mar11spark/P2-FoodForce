package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	
//	public Employee getEmployeeById(int id);

	public List<Employee> allEmployees();

}
