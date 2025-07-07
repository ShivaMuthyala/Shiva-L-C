package Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Entity.LikedArticle;
import Entity.News;
import Entity.User;

@Repository
public interface LikedArticleRepo extends JpaRepository<LikedArticle, Long> {
	List<LikedArticle> findByUser(User user);

	Optional<LikedArticle> findByUserAndNews(User user, News news);

}
