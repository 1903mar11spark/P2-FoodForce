package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Food;

@RestController
public class FoodController {
	
	@GetMapping
	public List<Food> list() {
		List<Food> foodList = new ArrayList<>();
		return foodList;
	}
	
	@GetMapping("food")
	public List<Food> getFoods() {
		List<Food>  foods = new ArrayList();
		Food f1 = new Food();
		f1.setDescription("desc1");
		f1.setName("name1");
		f1.setType("type1");
		
		foods.add(f1);
		return foods;
	}
}