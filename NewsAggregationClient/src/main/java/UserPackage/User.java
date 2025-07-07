package UserPackage;

public class User {

	public String userName;
	public String email;
	public String password;
	public String role;

	public User() {

	}

	public User(String userName, String email, String password, String role) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
