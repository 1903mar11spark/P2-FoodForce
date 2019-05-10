package com.revature.dao;

import com.revature.beans.Credential;
import com.revature.beans.Customer;

public interface CredentialDAO {
	
	public Credential getCredentials(String un, String pw);
	public Credential newUserCredentials(String username, String password);

}
