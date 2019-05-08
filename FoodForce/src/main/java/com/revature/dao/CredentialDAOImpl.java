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
		return null;
	}

}
