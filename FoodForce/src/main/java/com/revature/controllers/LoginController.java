package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.beans.Employee;
import com.revature.service.EmployeeService;

@Controller
@RequestMapping("/login")
public class LoginController {

//	@Autowired
//	private CredentialService credserv;
//	

	
	public LoginController() {
		
	}
	
	//user object mapper jackson to return id of person logging in
//	@PostMapping("/")
//	public ResponseEntity<>login(@RequestBody Credential cred) {
//		Credential cred = credserv.getCredentialById(id);
//		if (cred != null) {
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//		} else {
//			return new ResponseEntity<>(cred, HttpStatus.OK);
//		}
//		//1 fetech credential from DB
//		//2. get employee or customer
//		//3. return success or not
//		
//	}
	
	
	
	
	
	

}
