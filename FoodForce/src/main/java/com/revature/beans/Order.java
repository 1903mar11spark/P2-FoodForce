package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class Order {
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, String status, float total, Customer customer, Employee employee) {
		super();
		this.id = id;
		this.status = status;
		this.total = total;
		this.customer = customer;
		this.employee = employee;
	}

	@Id // indicates a primary key
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "orderSequence")
	@SequenceGenerator(allocationSize = 1, name = "orderSequence", sequenceName = "SQ_ORDER_PK")
	@Column(name = "ORDERID")
	protected int id;
	
	@Column(name = "STATUS")
	protected String status; //could also be an enum
	
	@Column(name = "TOTAL")
	protected float total;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CUSTOMERID")
	protected Customer customer;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEEID")
	protected Employee employee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", total=" + total + ", customer=" + customer + ", employee="
				+ employee + "]";
	}
	
	
	
}
