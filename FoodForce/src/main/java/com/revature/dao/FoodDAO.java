package com.revature.dao;

import java.util.List;

import com.revature.beans.Food;

public interface FoodDAO {
	
	public void createFood(Food food);
	public Food getFoodByType(String type);
	public List<Food> getAllFood();
	public void updateFood(Food food);
	public void deleteFood(Food food);
	
}
