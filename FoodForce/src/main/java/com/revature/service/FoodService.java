package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.FoodDAO;
import com.revature.entities.Food;

@Service
public class FoodService {
	
	private FoodDAO foodDAO;
	
	@Autowired
	public FoodService(FoodDAO foodDAO) {
		this.foodDAO = foodDAO;
	}
	
	
	//create Food
	public void createFood(Food food) {
		foodDAO.createFood(food);
	}
	
	//get food by type
	public Food getFoodByType(String type) {
		return foodDAO.getFoodByType(type);
	}
	
	public List<Food> getFoodsByType(String type) {
		return foodDAO.getFoodsByType(type);
	}
	
	
	//Get all Foods
	public List<Food> getAllFood(){
		return foodDAO.getAllFood();
	}
	//updatefood
	public void updateFood(int id, Food food) {
		foodDAO.updateFood(id,food);
	}
	
	//delete food
	public void deleteFood(int id) {
		foodDAO.deleteFood(id);
	}
	
	public Food getFoodById(int id) {
		return foodDAO.getFoodById(id);
	}


}
