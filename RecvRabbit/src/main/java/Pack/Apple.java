package Pack;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
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
}

@Component
class RecvModule {
	
	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name="exchange01", type=ExchangeTypes.TOPIC), value = @Queue(name = "queue01"), key = "routingKey01"))
	public void receiver(String msg) {
		System.out.println(msg);
	}
	
}
