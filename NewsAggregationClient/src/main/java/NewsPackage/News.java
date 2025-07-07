package NewsPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Scanner;

public class News {
	private static final int PAGE_SIZE = 10;
	private Scanner scanner = new Scanner(System.in);

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
			showPaginated(newsArray);
		} else {
			System.out.println("Failed to fetch news. HTTP Code: " + responseCode);
		}
	}

	private void showPaginated(org.json.JSONArray newsArray) throws IOException {
		int currentPage = 0;
		int totalNews = newsArray.length();
		int totalPages;

		if (totalNews % PAGE_SIZE == 0) {
			totalPages = totalNews / PAGE_SIZE;
		} else {
			totalPages = totalNews / PAGE_SIZE + 1;
		}

		while (true) {
			int startIndex = currentPage * PAGE_SIZE;
			int endIndex = startIndex + PAGE_SIZE;
			if (endIndex > totalNews) {
				endIndex = totalNews;
			}

			System.out.println("\n-- Page " + (currentPage + 1) + " of " + totalPages + " --\n");

			for (int i = startIndex; i < endIndex; i++) {
				JSONObject news = newsArray.getJSONObject(i);
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
				int finalChoice = scanner.nextInt();

				if (finalChoice == 1) {
					currentPage = 0;
				} else if (finalChoice == 2) {
					if (currentPage == 0) {
						System.out.println("This is the first page.");
					} else {
						currentPage = currentPage - 1;
					}
				} else if (finalChoice == 3) {
					System.out.println("Logged out successfully.\n");
					Authenticator.Authentication.showMainMenu();
					return;
				} else {
					System.out.println("Invalid choice.");
				}

			} else {
				System.out.println("1. Next\n2. Back\n3. Logout");
				int choice = scanner.nextInt();

				if (choice == 1) {
					currentPage = currentPage + 1;
				} else if (choice == 2) {
					if (currentPage == 0) {
						System.out.println("This is the first page.");
					} else {
						currentPage = currentPage - 1;
					}
				} else if (choice == 3) {
					System.out.println("Logged out successfully.\n");
					Authenticator.Authentication.showMainMenu();
					return;
				} else {
					System.out.println("Invalid choice.");
				}
			}
		}
	}
}
