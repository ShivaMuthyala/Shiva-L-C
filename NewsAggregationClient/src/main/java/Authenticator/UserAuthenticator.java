package Authenticator;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import DTO.LoginRequest;
import DTO.SignUpRequest;
import NewsPackage.News;
import org.json.JSONObject;

public class UserAuthenticator {
    private static final String BASE_URL = "http://localhost:9494";
    private final News news = new News();

    public void login(LoginRequest loginRequest) throws IOException {
        URL url = new URL(BASE_URL + "/api/login");
        HttpURLConnection connection = createPostConnection(url);

        JSONObject body = new JSONObject();
        body.put("userName", loginRequest.getUserName());
        body.put("password", loginRequest.getPassword());

        sendRequest(connection, body);

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            System.out.println("Login successful!");
            news.fetchNews();
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }
    }

    public void signUp(SignUpRequest signUpRequest) throws IOException {
        URL url = new URL(BASE_URL + "/api/signUp");
        HttpURLConnection connection = createPostConnection(url);

        JSONObject body = new JSONObject();
        body.put("userName", signUpRequest.getUserName());
        body.put("password", signUpRequest.getPassword());
        body.put("email", signUpRequest.getEmail());

        sendRequest(connection, body);

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            System.out.println("Sign-up successful!");
        } else {
            System.out.println("Sign-up failed. Try a different username.");
        }
    }

    private HttpURLConnection createPostConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        return connection;
    }

    private void sendRequest(HttpURLConnection connection, JSONObject body) throws IOException {
        try (OutputStream os = connection.getOutputStream();
             OutputStreamWriter writer = new OutputStreamWriter(os)) {
            writer.write(body.toString());
            writer.flush();
        }
    }
}
