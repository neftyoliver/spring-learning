package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);

		HelloController controller0 = new HelloController();

		System.out.println(controller0.getHello());
	}
}
