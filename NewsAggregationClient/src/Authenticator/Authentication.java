package Authenticator;

import java.io.IOException;
import java.util.Scanner;
import Menu.*;

public class Authentication {
	static UserAuthenticator userAuthenticator = new UserAuthenticator();

	public static void AuthenticationMenu() throws IOException {
//		User user = new User();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the News Aggregator application. Please choose the options below\n"
				+ "1. Login\n" + "2. Sign \n" + "3.Exit");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			LoginFlowMenu loginFlow = new LoginFlowMenu();
			loginFlow.getLoginFlow();
			break;
		case 2:
			SignUpFlowMenu signUpFlow = new SignUpFlowMenu();
			signUpFlow.getSignFlow();
			break;
		case 3:
			System.out.println("Exiting the application");
			break;
		}
		scanner.close();
	}

	public static void main(String[] args) throws IOException {
		Authentication.AuthenticationMenu();
	}
}
