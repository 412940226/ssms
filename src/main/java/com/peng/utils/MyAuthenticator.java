package com.peng.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
	private String username;
	private String password;
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
	public MyAuthenticator(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
}
