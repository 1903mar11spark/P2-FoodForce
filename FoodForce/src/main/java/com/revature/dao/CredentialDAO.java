package com.revature.dao;

import com.revature.beans.Credential;

public interface CredentialDAO {
	
	public Credential getCredentials(Credential cred);
	public Credential getCredentialById(int id);

}
