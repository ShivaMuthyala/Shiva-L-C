package NewsAggregationServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"NewsAggregation", "Entity", "Controller"})
@EnableJpaRepositories(basePackages = "Repo")
@EntityScan(basePackages = "Entity")
@EnableScheduling
public class NewsAggregationApplication {
	public static void main(String[] args) {
		SpringApplication.run(NewsAggregationApplication.class, args);
	}
}
