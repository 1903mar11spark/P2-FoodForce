package com.revature.dao;

import java.util.List;

import com.revature.entities.Food;

public interface FoodDAO {
	
	public void createFood(Food food);
	public Food getFoodByType(String type);
	public List<Food> getAllFood();
	public void updateFood(int id,Food food);
	public void deleteFood(int id);
	public Food getFoodById(int id);

	public List<Food> getFoodsByType(String type);
	
}
