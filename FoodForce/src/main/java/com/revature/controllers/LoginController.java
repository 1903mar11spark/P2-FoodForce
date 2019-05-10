package com.revature.controllers;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Credential;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.LoginResponse;
import com.revature.beans.User;
import com.revature.exceptions.UserNotFoundException;
import com.revature.service.CredentialService;
import com.revature.service.CustomerService;
import com.revature.service.EmployeeService;

@RestController
public class LoginController {

	@Autowired
	private CredentialService credserv;
	@Autowired
	private EmployeeService eserv;
	@Autowired
	private CustomerService cserv;
	
	

	
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
	
	/*
	@GetMapping("/login")
	public LoginResponse login(@RequestParam(value="username") String un, @RequestParam(value="password") String pw, final HttpSession session) throws UserNotFoundException {
		
		Credential cr = credserv.getCredentials(un, pw);
		System.out.println(session.getId());
		if (cr == null) {
			throw new UserNotFoundException();	
		}
		LoginResponse lr = new LoginResponse();
		lr.setMessage("sucess");
		Employee e = eserv.getEmployeeByCredentialId(cr.getId());
		if (e != null) {
			session.setAttribute("user", (User) e);
			lr.setUser(e);
			return lr;
		}
		Customer c = cserv.getCustomerByCredentialId(cr.getId());
		if(c != null) {
			session.setAttribute("user", (User) e);
			lr.setUser(c);
			return lr;
		}
		
		throw new UserNotFoundException();
	}
	*/
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
