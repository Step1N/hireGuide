

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.hireguide.*")
@EnableMongoRepositories
public class HireGuideApplication {

	public static void main(String[] args) {
		SpringApplication.run(HireGuideApplication.class, args);
	}

}
