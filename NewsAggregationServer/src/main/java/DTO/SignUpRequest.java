package DTO;

import Entity.User;

public class SignUpRequest {
	private String userName;
	private String email;
	private String password;
	private User.isAdmin isAdmin;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User.isAdmin getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(User.isAdmin isAdmin) {
		this.isAdmin = isAdmin;
	}
}
