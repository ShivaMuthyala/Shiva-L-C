package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.NewsDTO;
import Entity.News;
import Repo.NewsRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewsController {

	@Autowired
	NewsRepo newsRepo;
	@Scheduled(cron = "0 0 */2 * * *")
	@PostMapping("/api/fetchNews")
	public ResponseEntity<String> fetchNews() throws JsonProcessingException {
		String apiUrl = "https://api.thenewsapi.com/v1/news/top?api_token=hZEwbDkKg3ZSRJRVrZZFbKhXFkAlVESd0fWyXvJZ&locale=us&limit=3";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			String responseBody = response.getBody();

			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(responseBody);
			JsonNode dataArray = root.get("data");

			List<News> newsList = new ArrayList<>();

			for (JsonNode item : dataArray) {
				News news = new News();
				news.setUuid(item.path("uuid").asText());
				news.setTitle(item.path("title").asText());
				news.setDescription(item.path("description").asText());
				news.setKeywords(item.path("keywords").asText());
				System.out.println(item.path("keywords").asText());
				news.setSnippet(item.path("snippet").asText());
				news.setUrl(item.path("url").asText());
				news.setImage_url(item.path("image_url").asText());
				news.setPublished_at(item.path("published_at").asText());
				news.setSource(item.path("source").asText());
				newsList.add(news);
			}

			newsRepo.saveAll(newsList);
			return ResponseEntity.status(HttpStatus.OK).body("News stored Successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to fetch news.");
		}

	}

	@GetMapping("/api/getNews")
	public ResponseEntity<List<News>> getAllNews() {
	    List<News> newsList = newsRepo.findAll();
	    return ResponseEntity.ok(newsList);
	}

}
