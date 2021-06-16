package com.coderscampus.uservalidation;

public class NormalUser extends User {

	public NormalUser (String username, String password, String name) {
		this.setUsername(username);
		this.setPassword(password);
		this.setName(name);
		this.role = "normal_user";
	}

}
