package com.revature.dao;

import org.hibernate.SessionFactory;

import com.revature.beans.Credential;

public class CredentialDAOImpl implements CredentialDAO {

	private SessionFactory sessionFactory;

	
	public CredentialDAOImpl() {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Credential getCredentials(Credential cred) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Credential getCredentialById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
