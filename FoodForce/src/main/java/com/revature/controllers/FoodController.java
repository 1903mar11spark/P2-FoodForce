package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Employee;
import com.revature.beans.Food;
import com.revature.service.FoodService;

@RestController
@RequestMapping(value = "/food")
public class FoodController {
	
	private FoodService foodService;
	
	@Autowired
	public FoodController(FoodService foodService) {
		this.foodService = foodService;
	}

	@CrossOrigin(origins = "http://localhost:4200/customer/menu/pizza")
	@GetMapping("/")
	public List<Food> home() {
		List<Food> food = foodService.getAllFood();
		System.out.println(food);
		return food;
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
	
	
	@GetMapping(value = "/{type}")
	public ResponseEntity<Food> getFoodByType (@PathVariable String type){
		Food f = foodService.getFoodByType(type);
		if(f == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(f,HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Food>> getAllFood(){
			return new ResponseEntity<>(foodService.getAllFood(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> updateFood(@RequestBody Food food){
		ResponseEntity<String> resp = null;
		try {
			foodService.updateFood(food);
			resp = new ResponseEntity<>("Food updated succesfully", HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to update Food", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteFood(@RequestBody Food food){
		ResponseEntity<String> resp = null;
		try {
			foodService.deleteFood(food);
			resp = new ResponseEntity<>("Food deleted succesfully", HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to delete Food", HttpStatus.BAD_REQUEST)
;		}
		
		return resp;
	}
	
	
	
}
