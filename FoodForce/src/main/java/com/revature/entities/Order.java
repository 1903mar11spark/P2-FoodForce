package com.revature.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "Orders")
@Component
public class Order {
	
	public Order() {
		super();
		
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CUSTOMERID")
	protected Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEEID")
	protected Employee employee;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "FOODORDER", 
        joinColumns = { @JoinColumn(name = "ORDERID") }, 
        inverseJoinColumns = { @JoinColumn(name = "FOODID") })
	protected Set<Food> food = new HashSet<Food>();
	
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
