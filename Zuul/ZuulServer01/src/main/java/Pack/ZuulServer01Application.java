package Pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy // @EnableDiscoveryClient 동일하다.
public class ZuulServer01Application {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServer01Application.class, args);
	}
	// eureka zuul
	// filtertype
	// pre 
}
