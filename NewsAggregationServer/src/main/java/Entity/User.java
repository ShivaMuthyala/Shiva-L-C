package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String email;
	private String password;
	private isAdmin isAdmin;

	public enum isAdmin {
		User,
		Admin
	}

	public User(int userId, String userName, String email, String password, User.isAdmin isAdmin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", isAdmin=" + isAdmin + "]";
	}

	public User() {
		super();

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public isAdmin getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(isAdmin isAdmin) {
		this.isAdmin = isAdmin;
	}

}
