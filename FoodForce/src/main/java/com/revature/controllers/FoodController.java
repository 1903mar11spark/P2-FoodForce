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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Employee;
import com.revature.entities.Food;
import com.revature.service.FoodService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/food")
public class FoodController {
	
	private FoodService foodService;
	
	@Autowired
	public FoodController(FoodService foodService) {
		this.foodService = foodService;
	}

//This method already exists below, should we delete it
//	@GetMapping("/")
//	@ResponseBody
//	public List<Food> home() {
//		List<Food> food = foodService.getAllFood();
//		System.out.println(food);
//		return food;
//	}
	
	
	//create new Food
	@PostMapping("/create")
	public ResponseEntity<?> createFood(@RequestBody Food food){
		ResponseEntity<?> resp = null;
		try {
			foodService.createFood(food);
			resp = new ResponseEntity<>("Food created succesfully",HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to create food",HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	//I think type should be an Integer so we can pass it in, i cant find a way to pass in a String that works
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
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateFood(@PathVariable int id, @RequestBody Food food){
		ResponseEntity<?> resp = null;
		try {
			foodService.updateFood(id,food);
			resp = new ResponseEntity<>("Food with id of " + id +  " was updated succesfully", HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to update Food", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteFood(@PathVariable int id){
		ResponseEntity<String> resp = null;
		try {
			foodService.deleteFood(id);
			resp = new ResponseEntity<>("Food with id of " + id + " was deleted succesfully", HttpStatus.OK);
		}catch(Exception e) {
			resp = new ResponseEntity<>("Failed to delete Food", HttpStatus.BAD_REQUEST);		}
		
		return resp;
	}	
}
