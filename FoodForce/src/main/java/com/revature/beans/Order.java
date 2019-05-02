package com.revature.beans;

public class Order {
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, String status, float total, Customer customer, Employee eployeee) {
		super();
		this.id = id;
		this.status = status;
		this.total = total;
		this.customer = customer;
		this.eployeee = eployeee;
	}

	protected int id;
	protected String status; //could also be an enum
	protected float total;
	protected Customer customer;
	protected Employee eployeee;
	
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
	public Employee getEployeee() {
		return eployeee;
	}
	public void setEployeee(Employee eployeee) {
		this.eployeee = eployeee;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", total=" + total + ", customer=" + customer + ", eployeee="
				+ eployeee + "]";
	}
	
	
	
}
