package hackathon6.jolt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JoltWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoltWebApplication.class, args);
		
		new DataStore();
	}
}
