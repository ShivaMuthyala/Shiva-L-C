package Utilities;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Common {
	private final String BASE_URL = "http://localhost:9494";

	public String getBaseUrl() {
		return BASE_URL;
	}

	public HttpURLConnection createPostConnection(URL url) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/json");
		return connection;
	}

	public void sendRequest(HttpURLConnection connection, JSONObject body) throws IOException {
		try (OutputStream os = connection.getOutputStream(); OutputStreamWriter writer = new OutputStreamWriter(os)) {
			writer.write(body.toString());
			writer.flush();
		}
	}
}
