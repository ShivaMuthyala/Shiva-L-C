package Authenticator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserAuthenticator {
String userName;
String password;
static URL url;
public static void getUserDetails(String userName) throws IOException {
	url = new URL("http://localhost:9494/api/user/"+ userName);
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	connection.setRequestMethod("GET");


    int responseCode = connection.getResponseCode();
    System.out.println("Response Code: " + responseCode);


    BufferedReader in = new BufferedReader(
    new InputStreamReader(connection.getInputStream()));
    String inputLine;
    StringBuilder response = new StringBuilder();
    while ((inputLine = in.readLine()) != null) {
    	response.append(inputLine);
    }
    in.close();

    System.out.println(response);


}
public static void validationMenu() {
	System.out.println("Welcome to the News Aggregator application. Please choose the options below \n"
			+ "1.SignUp \n"
			+"2.Login \n"
			+"3.Exit");
}
public static void main(String[] args) throws IOException {
	UserAuthenticator.getUserDetails("Shankar");
}
}
