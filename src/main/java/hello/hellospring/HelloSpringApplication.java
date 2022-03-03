package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloSpringApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext springApp = SpringApplication.run(HelloSpringApplication.class, args);
	}
}
