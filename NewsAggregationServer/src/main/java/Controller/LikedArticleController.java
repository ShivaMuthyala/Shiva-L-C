package Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import Entity.LikedArticle;
import Entity.News;
import Entity.User;
import Repo.LikedArticleRepo;
import Repo.NewsRepo;
import Repo.UserRepo;

@RestController
@RequestMapping("/api/liked")
public class LikedArticleController {

	@Autowired
	private LikedArticleRepo likedArticleRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private NewsRepo newsRepo;

	@PostMapping("/save")
	public ResponseEntity<String> saveLikedArticle(@RequestParam String username, @RequestParam int newsId) {
		Optional<User> userOpt = userRepo.findByUserName(username);
		Optional<News> newsOpt = newsRepo.findById(newsId);

		if (!userOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}

		if (!newsOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("News article not found");
		}

		User user = userOpt.get();
		News news = newsOpt.get();

		Optional<LikedArticle> existing = likedArticleRepo.findByUserAndNews(user, news);
		if (existing.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Article already liked by user");
		}

		System.out.println("The present user is: " + user);

		LikedArticle likedArticle = new LikedArticle(user, news);
		likedArticleRepo.save(likedArticle);
		return ResponseEntity.ok("Article liked successfully");
	}

	@GetMapping("/all")
	public ResponseEntity<List<LikedArticle>> getLikedArticles(@RequestParam String username) {
		Optional<User> userOpt = userRepo.findByUserName(username);
		if (!userOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		List<LikedArticle> likedArticles = likedArticleRepo.findByUser(userOpt.get());
		return ResponseEntity.ok(likedArticles);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteLikedArticle(@RequestParam String userName, @RequestParam int newsId) {
		Optional<User> userOpt = userRepo.findByUserName(userName);
		Optional<News> newsOpt = newsRepo.findById(newsId);

		if (!userOpt.isPresent() || !newsOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or news not found");
		}

		Optional<LikedArticle> likedArticleOpt = likedArticleRepo.findByUserAndNews(userOpt.get(), newsOpt.get());
		if (!likedArticleOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Like not found");
		}

		likedArticleRepo.delete(likedArticleOpt.get());
		return ResponseEntity.ok("Article unliked successfully");
	}
}
