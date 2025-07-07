package Menu;

import java.io.IOException;
import java.util.Scanner;

import Authenticator.UserAuthenticator;
import DTO.SignUpRequest;

public class SignUpFlowMenu {
	private final UserAuthenticator userAuthenticator = new UserAuthenticator();
	private final Scanner scanner;

	public SignUpFlowMenu(Scanner scanner) {
		this.scanner = scanner;
	}

	public void handleSignUpFlow() throws IOException {
		System.out.print("Enter username: ");
		String username = scanner.nextLine();

		System.out.print("Enter password (min 6 chars): ");
		String password = scanner.nextLine();

		System.out.print("Enter email: ");
		String email = scanner.nextLine();

		if (username.isEmpty() || password.length() < 6 || !email.contains("@")) {
			System.out.println("Invalid input. Please check username, password, and email format.");
			return;
		}

		SignUpRequest request = new SignUpRequest();
		request.setUserName(username);
		request.setPassword(password);
		request.setEmail(email);

		userAuthenticator.signUp(request);
	}
}
