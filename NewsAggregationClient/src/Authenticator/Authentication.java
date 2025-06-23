package Authenticator;

import java.io.IOException;
import java.util.Scanner;
import UserPackage.User;

public class Authentication {
	static UserAuthenticator userAuthenticator = new UserAuthenticator();

	public static void AuthenticationMenu() throws IOException {
		User user = new User();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the News Aggregator application. Please choose the options below\n"
				+ "1. Login\n" + "2. Sign \n" + "3.Exit");
		int choice = scanner.nextInt();
		switch (choice) {
			case 1:
				System.out.println("Please enter User Name");
				user.userName = scanner.next();
				System.out.println("Please enter password");
				user.password = scanner.next();
				userAuthenticator.LoginFlow(user.userName, user.password);
				break;
			case 2:
				System.out.println("Please enter User Name");
				user.userName = scanner.next();
				System.out.println("Please enter password");
				user.password = scanner.next();
				System.out.println("Please enter email");
				user.email = scanner.next();
				System.out.println("Please choose a role Admin or User");
				String roleInput = scanner.next();

				user.role = User.Role.valueOf(roleInput.toUpperCase());
				userAuthenticator.signUpFlow(user.userName, user.password, user.email, user.role);
				break;
			case 3:
				System.out.println("Exiting the application");
		}
		scanner.close();
	}

	public static void main(String[] args) throws IOException {
		Authentication.AuthenticationMenu();
	}
}
