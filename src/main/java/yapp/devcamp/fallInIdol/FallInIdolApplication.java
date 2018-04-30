package yapp.devcamp.fallInIdol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FallInIdolApplication {

	public static void main(String[] args) {
		SpringApplication.run(FallInIdolApplication.class, args);
	}
}