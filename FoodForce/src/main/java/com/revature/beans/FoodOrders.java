package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FoodOrder")
public class FoodOrders {

	
	@Id // indicates a primary key
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "foodorderSequence")
	@SequenceGenerator(allocationSize = 1, name = "foodorderSequence", sequenceName = "SQ_CREDENTIAL_PK")
	@Column(name = "FOODORDERID")
	protected int id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "FOODID")
	protected Food food;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "ORDERID")
	protected Order order;
	
	public FoodOrders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FoodOrders(int id, Food food, Order order) {
		super();
		this.id = id;
		this.food = food;
		this.order = order;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Food getFoodid() {
		return food;
	}
	
	public void setFoodid(Food food) {
		this.food = food;
	}
	
	public Order getOrderid() {
		return order;
	}
	
	public void setOrderid(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "FoodOrders [id=" + id + ", food=" + food + ", order=" + order + "]";
	}
	
}
