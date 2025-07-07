package Authenticator;

import java.io.IOException;
import java.util.Scanner;
import Menu.*;

public class Authentication {
	static UserAuthenticator userAuthenticator = new UserAuthenticator();
	static Scanner scanner = new Scanner(System.in);
	private final static int LOGIN = 1;
	private final static int SIGNUP = 2;
	private final static int EXIT = 3;

	public static void showMainMenu() throws IOException {
		while (true) {
			System.out.println("\nWelcome to the News Aggregator application. Please choose:");
			System.out.println("1. Login\n2. Signup\n3. Exit application");
			int choice = scanner.nextInt();

			switch (choice) {
			case LOGIN:
				new LoginFlowMenu(scanner).handleLoginFlow();
				break;
			case SIGNUP:
				new SignUpFlowMenu(scanner).handleSignUpFlow();
				break;
			case EXIT:
				System.out.println("Successfully exited the system");
				System.exit(0);
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		showMainMenu();
	}
}
