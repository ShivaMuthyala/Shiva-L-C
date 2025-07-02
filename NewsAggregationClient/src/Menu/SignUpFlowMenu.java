package Menu;

import java.io.IOException;
import java.util.Scanner;

import Authenticator.UserAuthenticator;
import DTO.SignUpRequest;

public class SignUpFlowMenu {
	UserAuthenticator userAuthenticator = new UserAuthenticator();
	Scanner scanner = new Scanner(System.in);

	public void getSignFlow() throws IOException {
		SignUpRequest signUpRequest = new SignUpRequest();
		System.out.println("Please enter User Name");
		signUpRequest.setUserName(scanner.next());
		System.out.println("Please enter password");
		signUpRequest.setPassword(scanner.next());
		System.out.println("Please enter email");
		signUpRequest.setEmail(scanner.next());
		userAuthenticator.signUpFlow(signUpRequest);
	}
}