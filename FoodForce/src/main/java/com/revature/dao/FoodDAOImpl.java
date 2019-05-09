package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.revature.beans.Food;

@Repository(value = "FoodDAO")
@Transactional
public class FoodDAOImpl implements FoodDAO {

	@Override
	public void createFood(Food food) {
		
		
	}

	@Override
	public Food getFoodByType(String type) {
		
		return null;
	}

	@Override
	public List<Food> getAllFood(Food food) {
		
		return null;
	}

	@Override
	public Food updateFood(Food food) {
		
		return null;
	}

	@Override
	public Food deleteFood(Food food) {
		
		return null;
	}

}
