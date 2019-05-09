package com.revature.dao;

import com.revature.beans.Credential;

public interface CredentialDAO {
	
	public Credential getCredentials(String username, String password);
	public Credential getCredentialsById(int id);
	public Credential newUserCredentials(String username, String password);

}
