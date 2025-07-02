package Menu;

import java.io.IOException;
import java.util.Scanner;

import Authenticator.UserAuthenticator;
import DTO.LoginRequest;

public class LoginFlowMenu {
	UserAuthenticator userAuthenticator = new UserAuthenticator();
	Scanner scanner = new Scanner(System.in);
	public void getLoginFlow() throws IOException {
	LoginRequest loginRequest = new LoginRequest();
	System.out.println("Please enter User Name");
	loginRequest.setUserName(scanner.next());
	System.out.println("Please enter password");
	loginRequest.setPassword(scanner.next());
	userAuthenticator.LoginFlow(loginRequest);
}
}
