package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.beans.Credential;
import com.revature.beans.Employee;
import com.revature.service.CredentialService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private CredentialService credserv;
	

	
	public LoginController() {
		
	}
	
	//use object mapper jackson to return id of person logging in
//	@PostMapping("/")
//	public ResponseEntity<Credential>getCredentialById(@RequestBody int id) {
//		Credential cred = credserv.getCredentialById(1);
//		if (cred != null) {
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//		} else {
//			return new ResponseEntity<>(cred, HttpStatus.OK);
//		}
////		//1 fetech credential from DB
////		//2. get employee or customer
////		//3. return success or not
////		
//	}
	
	
	@GetMapping("/")
	public String loggedin() {
		Credential cr = credserv.getCredentialById(1);
		System.out.println(cr);
		return "login";
	}
	
//	@GetMapping(value="/{id}")
//	public ResponseEntity<Credential> getCredentialById(@PathVariable int id){
//		Credential cr = credserv.getCredentialById(1);
//		if (cr == null) {
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//		} else {
//			return new ResponseEntity<>(cr, HttpStatus.OK);
//		}
//	}
	
	
	
	
	

}
