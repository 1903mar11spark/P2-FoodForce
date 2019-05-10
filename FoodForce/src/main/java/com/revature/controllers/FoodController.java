package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Food;
import com.revature.service.FoodService;

@RestController
@RequestMapping(value = "/food")
public class FoodController {
	
	private FoodService foodService;
	
	@Autowired
	public FoodController(FoodService foodService) {
		this.foodService = foodService;
	}

	//create new Food
	@PostMapping
	public ResponseEntity<String> createFood(@RequestBody Food food){
		ResponseEntity<String> resp = null;
		try {
			foodService.createFood(food);
			resp = new ResponseEntity<>("Food created succesfully",HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to create food",HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	
}
