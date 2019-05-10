package com.revature.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.entities.Credential;

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
	public Credential getCredentials(String un, String pw) {
		try {
			Session session = sessionFactory.getCurrentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Credential> query = builder.createQuery(Credential.class);
			Root<Credential> root = query.from(Credential.class);
	        query.select(root).where(builder.and(builder.equal(root.get("username"), un), builder.equal(root.get("password"), pw)));
	        
	        //root.get("password"), pw)

	        Query<Credential> q = session.createQuery(query);
	        Credential cred = q.getSingleResult();
	        return cred;	
		} catch (Exception e) {
	         
	         return null;
	   }
				
	}

	@Override
	public Credential newUserCredentials(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
