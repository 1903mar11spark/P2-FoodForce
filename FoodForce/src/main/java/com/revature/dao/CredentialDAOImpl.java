package com.revature.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.beans.Credential;

@Repository
@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
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

	@Override
	public Credential newUserCredentials(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
