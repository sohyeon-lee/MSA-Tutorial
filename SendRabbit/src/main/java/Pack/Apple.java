package Pack;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Apple {
	@RequestMapping("/")
	public String func00() {
		System.out.println("Apple class Call");
		
		return "index";
	}

	@RequestMapping("/t1")
	public String func01() {
		System.out.println("func01 Call");
		
		return "AppleView";
	}

	/* ===================================================================
		RabbitMQ - queue
	==================================================================== */
	@Autowired // 개발자가 코드로 빈 생성을 해주지 않아도 된다. dependency를 추가하면서 내부적으로 빈이 생성된다. 
	RabbitTemplate rabbitTemplate;
	
	@RequestMapping("/t2")
	public String func02() {
		System.out.println("func02 Call");
		System.out.println(rabbitTemplate.hashCode()); // rabbitTemplate 객체 주입된 것 확인
		
		rabbitTemplate.convertAndSend(
			"exchange01",	// rabbit의 exchange와 매핑된다.
			"routingKey01",
			"LION"
		);
		return "redirect:/"; // 원래 페이지 refresh
	}
}
