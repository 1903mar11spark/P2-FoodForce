package com.revature.dao;

import org.hibernate.SessionFactory;

import com.revature.beans.Credential;

public class CredentialDAOImpl implements CredentialDAO {

	private SessionFactory sessionFactory;

	
	public CredentialDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//still trying to figure out this one
	@Override
	public Credential getCredentials(String username, String password) {
		return sessionFactory.getCurrentSession().get(Credential.class, username);
		
	}

	@Override
	public Credential getCredentialsById(int id) {
		return sessionFactory.getCurrentSession().get(Credential.class, id);
		
	}

}
