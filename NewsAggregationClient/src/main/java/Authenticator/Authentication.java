package Authenticator;

import java.io.IOException;
import java.util.Scanner;
import Menu.*;

public class Authentication {
	static UserAuthenticator userAuthenticator = new UserAuthenticator();
	static Scanner scanner = new Scanner(System.in);

	public static void showMainMenu() throws IOException {
		while (true) {
			System.out.println("\nWelcome to the News Aggregator application. Please choose:");
			System.out.println("1. Login\n2. Signup\n3. Exit application");
			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					new LoginFlowMenu(scanner).handleLoginFlow();
					break;
				case 2:
					new SignUpFlowMenu(scanner).handleSignUpFlow();
					break;
				case 3:
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
