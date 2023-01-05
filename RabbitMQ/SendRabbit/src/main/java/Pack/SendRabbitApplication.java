package Pack;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SendRabbitApplication {
	// 객체 전송 시 반드시 필요함
	// dto 클래스에서 serializable을 상속받아서 처리할 수도 있다.
	@Bean
	Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	public static void main(String[] args) {
		SpringApplication.run(SendRabbitApplication.class, args);
	}

}
