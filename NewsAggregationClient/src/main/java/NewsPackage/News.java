package NewsPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import Utilities.Common;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Scanner;

public class News {
	private final Common common = new Common();
	private static final int PAGE_SIZE = 10;
	private final Scanner scanner = new Scanner(System.in);

	private static final int START_OVER = 1;
	private static final int NEXT = 1;
	private static final int BACK = 2;
	private static final int LOGOUT = 3;

	public void fetchNews() throws IOException {
		URL url = new URL(common.getBaseUrl() + "/api/getNews");
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
			showPaginated(newsArray);
		} else {
			System.out.println("Failed to fetch news. HTTP Code: " + responseCode);
		}
	}

	private void showPaginated(JSONArray newsArray) throws IOException {
		int currentPage = 0;
		int totalNews = newsArray.length();
		int totalPages = (int) Math.ceil((double) totalNews / PAGE_SIZE);

		while (true) {
			int startIndex = currentPage * PAGE_SIZE;
			int endIndex = Math.min(startIndex + PAGE_SIZE, totalNews);

			System.out.println("\n-- Page " + (currentPage + 1) + " of " + totalPages + " --\n");
			for (int i = startIndex; i < endIndex; i++) {
				JSONObject news = newsArray.getJSONObject(i);
				System.out.println("Id          : " + news.getInt("newsId"));
				System.out.println("Title       : " + news.getString("title"));
				System.out.println("Description : " + news.optString("description"));
				System.out.println("Source      : " + news.getString("source"));
				System.out.println("Published At: " + news.getString("published_at"));
				System.out.println("URL         : " + news.getString("url"));
				System.out.println();
			}

			if (currentPage == totalPages - 1) {
				System.out.println("End of news.");
				System.out.println("1. Start Over\n2. Back\n3. Logout");
			} else {
				System.out.println("1. Next\n2. Back\n3. Logout");
			}

			int userChoice = scanner.nextInt();

			if (userChoice == START_OVER && currentPage == totalPages - 1) {
				currentPage = 0;
			} else if (userChoice == NEXT && currentPage < totalPages - 1) {
				currentPage++;
			} else if (userChoice == BACK) {
				if (currentPage == 0) {
					System.out.println("This is the first page.");
				} else {
					currentPage--;
				}
			} else if (userChoice == LOGOUT) {
				System.out.println("Logged out successfully.\n");
				Authenticator.Authentication.showMainMenu();
				return;
			} else {
				System.out.println("Invalid choice.");
			}
		}
	}

}
