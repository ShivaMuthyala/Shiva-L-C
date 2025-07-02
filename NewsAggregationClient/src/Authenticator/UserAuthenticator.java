package Authenticator;

import java.io.BufferedReader;
import NewsPackage.News;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import DTO.LoginRequest;
import DTO.SignUpRequest;
import NewsPackage.News;
import UserPackage.User;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class UserAuthenticator {
	enum isAdmin {
		User, Admin
	}

	URL url;
	Gson gson = new Gson();
	News news = new News();

	public void LoginFlow(LoginRequest loginRequest) throws IOException {
		url = new URL("http://localhost:9494/api/login");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/json");
		JsonObject json = new JsonObject();
		json.addProperty("userName", loginRequest.getUserName());
		json.addProperty("password", loginRequest.getPassword());
		String jsonString = json.toString();
		OutputStream os = connection.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		osw.write(jsonString);
		osw.flush();
//    System.out.println(jsonString);
		int responseCode = connection.getResponseCode();
		if (responseCode == 200) {
			System.out.println("Successfully logged in");
			news.fetchNews();
		} else {
			System.out.println("Invalid Credentials");
		}

	}

	public void signUpFlow(SignUpRequest signUpRequest) throws IOException {
		url = new URL("http://localhost:9494/api/signUp");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/json");

		JsonObject json = new JsonObject();
		json.addProperty("userName", signUpRequest.getUserName());
		json.addProperty("password", signUpRequest.getPassword());
		json.addProperty("email", signUpRequest.getEmail());

		try (OutputStream os = connection.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8")) {
			osw.write(json.toString());
			osw.flush();
		}

		int responseCode = connection.getResponseCode();
		if (responseCode == 200) {
//    	User user = new User();
//    	user.setEmail(email);
//    	user.setUserName(userName);
//    	user.setPassword(password);
//    	user.setRole(role);
			System.out.println("Sign up successful");
		} else {
			System.out.println("Sign up failed");
		}

	}

	public String getUserDetails(String userName, String requiredData) throws IOException {
		url = new URL("http://localhost:9494/api/user/username/" + userName);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		System.out.println(responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		System.out.println(response);
		JSONObject userJson = new JSONObject(response.toString());
		switch (requiredData) {
		case "userName":
			return userJson.getString("userName");
		case "email":
			return userJson.getString("email");
		case "password":
			return userJson.getString("password");
		case "isAdmin":
			return userJson.getString("isAdmin");
		default:
			return "User not found: " + requiredData;
		}

	}

}
