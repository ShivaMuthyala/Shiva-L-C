package Repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Entity.User;
public interface UserRepo extends JpaRepository<User, Integer>{
	@Query(value = "SELECT * FROM news_aggregation WHERE username=?",nativeQuery = true)
    public Optional<User> findByUsername(String username);
}
