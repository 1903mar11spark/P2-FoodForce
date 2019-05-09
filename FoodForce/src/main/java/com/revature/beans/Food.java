package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Food")
@Component
public class Food {

	
	@Id // indicates a primary key
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "foodSequence")
	@SequenceGenerator(allocationSize = 1, name = "foodSequence", sequenceName = "SQ_FOOD_PK")
	@Column(name = "FOODID")
	protected int id;
	
	@Column(name = "NAME")
	protected String name;
	
	@Column(name = "DESCRIPTION")
	protected String description; 
	
	@Column(name = "TYPE")
	protected String type;
	
	
	public Food() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type + "]";
	} 

	
	
	
}
