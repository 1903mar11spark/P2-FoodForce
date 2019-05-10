package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CredentialDAO;
import com.revature.dao.CredentialDAOImpl;
import com.revature.entities.Credential;
import com.revature.entities.Employee;



@Service
public class CredentialService {

	@Autowired
	private CredentialDAO creddao;
	
	
	public Credential getCredentials(String un, String pw) {
		return creddao.getCredentials(un, pw);		
	}
	
	public Credential newUserCredentials(String username, String password) {
		return null;
		
	}

}
