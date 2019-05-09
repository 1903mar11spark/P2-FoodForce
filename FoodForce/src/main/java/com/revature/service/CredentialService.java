package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CredentialDAO;
import com.revature.dao.CredentialDAOImpl;



@Service
public class CredentialService {

	@Autowired
	private CredentialDAO creddao;
	
	@Autowired
	public CredentialService(CredentialDAOImpl cred) {
		this.creddao = cred;
	}

}
