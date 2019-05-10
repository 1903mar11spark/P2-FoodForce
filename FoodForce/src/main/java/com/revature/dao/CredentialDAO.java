package com.revature.dao;

import com.revature.entities.Credential;
import com.revature.entities.Customer;

public interface CredentialDAO {
	
	public Credential getCredentials(String un, String pw);
	public Credential newUserCredentials(String username, String password);

}
