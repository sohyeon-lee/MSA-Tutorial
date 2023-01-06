package Pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Eureka02_1Application {

	public static void main(String[] args) {
		SpringApplication.run(Eureka02_1Application.class, args);
	}

}
