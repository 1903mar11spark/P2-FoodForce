package com.revature.beans;

public class Employee {
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String firstName, String lastName, int reportsTo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.reportsTo = reportsTo;
	}
	
	protected int id;
	protected String firstName;
	protected String lastName;
	protected int reportsTo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", reportsTo=" + reportsTo
				+ "]";
	}
	
	
}
