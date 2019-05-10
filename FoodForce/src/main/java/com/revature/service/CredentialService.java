package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Credential;
import com.revature.beans.Employee;
import com.revature.dao.CredentialDAO;
import com.revature.dao.CredentialDAOImpl;



@Service
public class CredentialService {

	@Autowired
	private CredentialDAO credDAO;
	
	

	public Credential getCredentials(String un, String pw) {
		return creddao.getCredentials(un, pw);		

	@Autowired
	public CredentialService(CredentialDAO cred) {
		this.credDAO = cred;
	}
	

	public Credential getCredentialsById(int id) {
		return credDAO.getCredentialsById(id);
	}
	
	
	
	//this method just returns null and does not call the DAO method
	public Credential newUserCredentials(String username, String password) {
		return null;
	}
	
	//Can we have this instead? 
//	public void newUserCredentials(String username, String password) {
//		credDAO.newUserCredentials(username, password);
//	}

}
