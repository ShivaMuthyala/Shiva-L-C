package NewsPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class News {
	URL url;
	public void fetchNews() throws IOException {
	    URL url = new URL("http://localhost:9494/api/getNews");
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    connection.setRequestMethod("GET");

	    int responseCode = connection.getResponseCode();
	    if (responseCode == 200) {
	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        StringBuilder response = new StringBuilder();
	        String line;

	        while ((line = in.readLine()) != null) {
	            response.append(line);
	        }
	        in.close();

	        JSONArray newsArray = new JSONArray(response.toString());

	        for (int i = 0; i < newsArray.length(); i++) {
	            JSONObject news = newsArray.getJSONObject(i);
	            System.out.println("");
//	            System.out.println("Id          : "+news.getInt("news_id") );
	            System.out.println("Title       : "+news.getString("title"));
	            System.out.println("Description : "+news.optString("description"));
	            System.out.println("Source      : "+news.getString("source"));
	            System.out.println("Published At: "+news.getString("published_at"));
	            System.out.println("URL         : "+news.getString("url"));
	            System.out.println();
	        }
	    } else {
	        System.out.println("Failed to fetch news. HTTP Code: " + responseCode);
	    }
	}
}
