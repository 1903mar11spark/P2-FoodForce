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
	private CredentialDAO credDAO;
	
	

	public Credential getCredentials(String un, String pw) {
<<<<<<< HEAD
		return credDAO.getCredentials(un, pw);		
	}
=======
		return credDAO.getCredentials(un, pw);
	}

>>>>>>> 7defba39aa3f9c42ea8f28b4b5070170d759592e
	@Autowired
	public CredentialService(CredentialDAO cred) {
		this.credDAO = cred;
	}
	

<<<<<<< HEAD
	public Credential getCredentialsById(String un, String pw) {
		return credDAO.getCredentials(un, pw);
	}
=======
//	public Credential getCredentialsById(int id) {
//		return credDAO.getCredentialsById(id);
//	}
>>>>>>> 7defba39aa3f9c42ea8f28b4b5070170d759592e
	
	
	
	//this method just returns null and does not call the DAO method
	public Credential newUserCredentials(String username, String password) {
		return null;
	}
	
	//Can we have this instead? 
//	public void newUserCredentials(String username, String password) {
//		credDAO.newUserCredentials(username, password);
//	}

}
