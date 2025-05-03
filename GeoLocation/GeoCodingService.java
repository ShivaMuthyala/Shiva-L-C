package GeoLocation;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;

public class GeoCodingService {
	private static final String API_KEY = "AIzaSyBdBk8ujQ311BLohK8kYNwN0OnQvgmWkf8";

	public void getCoordinatesForPlace(String place) throws IOException {
		String encodedPlace = URLEncoder.encode(place, "UTF-8");

		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + encodedPlace + "&key=" + API_KEY;

		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet request = new HttpGet(url);
			HttpEntity entity = httpClient.execute(request).getEntity();
			String jsonResponse = EntityUtils.toString(entity);

			JSONObject jsonObject = new JSONObject(jsonResponse);

			if (jsonObject.getJSONArray("results").length() > 0) {
				JSONObject location = jsonObject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry")
						.getJSONObject("location");

				System.out.println("lattitude: " + location.getDouble("lat"));
				System.out.println("longitude: " + location.getDouble("lng"));
			} else {
				throw new IOException("No results found for the place.");
			}
		}
	}
}
