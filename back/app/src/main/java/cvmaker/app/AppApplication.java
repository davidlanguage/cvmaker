package cvmaker.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {

	private static final String MESSAGE = "Thank you for using my app";

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> System.out.println(MESSAGE);
	}

}
