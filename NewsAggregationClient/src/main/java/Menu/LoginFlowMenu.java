package Menu;

import java.io.IOException;
import java.util.Scanner;

import Authenticator.UserAuthenticator;
import DTO.LoginRequest;

public class LoginFlowMenu {
	private final UserAuthenticator userAuthenticator = new UserAuthenticator();
	private final Scanner scanner;

	public LoginFlowMenu(Scanner scanner) {
		this.scanner = scanner;
	}

	public void handleLoginFlow() throws IOException {
		System.out.println("Enter username: ");
		String username = scanner.next();

		System.out.println("Enter password: ");
		String password = scanner.next();

		if (username.isEmpty() || password.length() < 4) {
			System.out.println(
					"Invalid credentials. Username can't be empty and password must be at least 6 characters.");
			return;
		}

		LoginRequest request = new LoginRequest(username, password);
		userAuthenticator.login(request);
	}
}
