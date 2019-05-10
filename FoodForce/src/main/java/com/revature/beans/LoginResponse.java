package com.revature.beans;

import com.revature.entities.User;

public class LoginResponse {

	private String message;
	
	private User user;
	
	public LoginResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
