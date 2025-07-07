package Authenticator;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import DTO.LoginRequest;
import DTO.SignUpRequest;
import NewsPackage.News;
import Utilities.Common;

import org.json.JSONObject;

public class UserAuthenticator {
	private final Common common = new Common();
	private final News news = new News();

	public void login(LoginRequest loginRequest) throws IOException {
		URL url = new URL(common.getBaseUrl() + "/api/login");
		HttpURLConnection connection = common.createPostConnection(url);

		JSONObject body = new JSONObject();
		body.put("userName", loginRequest.getUserName());
		body.put("password", loginRequest.getPassword());

		common.sendRequest(connection, body);

		int responseCode = connection.getResponseCode();
		if (responseCode == 200) {
			System.out.println("Login successful!");
			news.fetchNews();
		} else {
			System.out.println("Login failed. Please check your credentials.");
		}
	}

	public void signUp(SignUpRequest signUpRequest) throws IOException {
		URL url = new URL(common.getBaseUrl() + "/api/signUp");
		HttpURLConnection connection = common.createPostConnection(url);

		JSONObject body = new JSONObject();
		body.put("userName", signUpRequest.getUserName());
		body.put("password", signUpRequest.getPassword());
		body.put("email", signUpRequest.getEmail());

		common.sendRequest(connection, body);

		int responseCode = connection.getResponseCode();
		if (responseCode == 200) {
			System.out.println("Sign-up successful!");
		} else {
			System.out.println("Sign-up failed");
		}
	}

}
