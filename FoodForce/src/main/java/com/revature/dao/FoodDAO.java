package com.revature.dao;

import java.util.List;

import com.revature.beans.Food;

public interface FoodDAO {
	
	public void createFood(Food food);
	public Food getFoodByType(String type);
	public List<Food> getAllFood(Food food);
	public Food updateFood(Food food);
	public Food deleteFood(Food food);
	
	
	

}
