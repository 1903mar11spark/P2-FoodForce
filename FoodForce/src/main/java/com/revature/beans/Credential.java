package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Credential")
public class Credential {
	

	
	public Credential() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Credential(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	@Id // indicates a primary key
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "credentialSequence")
	@SequenceGenerator(allocationSize = 1, name = "credentialSequence", sequenceName = "SQ_CREDENTIAL_PK")
	@Column(name = "CREDENTIALID")
	protected int id;
	
	@Column(name = "USERNAME")
	protected String username;
	
	@Column(name = "PASSWORD")
	protected String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Credential [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	

	
	
	
}
