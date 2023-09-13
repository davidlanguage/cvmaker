package cvmaker.app;

import cvmaker.app.multilanguage.Languages;
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
		return args ->{
			System.out.println(MESSAGE);
			System.out.println("Language order: ");
			System.out.println(Languages.ENGLISH.getLanguage());
			System.out.println(Languages.SPANISH.getLanguage());
			System.out.println(Languages.GERMAN.getLanguage());
		};
	}

}
