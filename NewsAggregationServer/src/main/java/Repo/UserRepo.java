package Repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import Entity.User;
public interface UserRepo extends JpaRepository<User, Integer>{
	@Query(value = "SELECT * FROM news_aggregation.user WHERE user_name=?",nativeQuery = true)
    public Optional<User> findByUsername(String userName);
}
