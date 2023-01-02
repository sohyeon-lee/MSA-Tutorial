package Pack;

import java.io.Serializable;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

@Data
class Quiz {
	String username;
	String quiz;
	String useranswer;
}

@Component
class RecvModule {
	/* ===================================================================
		RabbitMQ - queue (문자열, 객체)
	==================================================================== */
	
//	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name="exchange01", type=ExchangeTypes.TOPIC), value = @Queue(name = "queue01"), key = "routingKey01"))
//	public void shopReceiver(Quiz quiz) {
//		System.out.println(quiz.toString());
//	}
	
//	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name="exchange01", type=ExchangeTypes.TOPIC), value = @Queue(name = "queue01"), key = "routingKey01"))
//	public void personReceiver(Person person) {
//		System.out.println(person.toString());
//	}

	/* ===================================================================
		RabbitMQ - tutorial 1,2
	==================================================================== */
//	@RabbitListener(queues = "hello") // RecvRabbitApplication 클래스에서 queue 빈 생성 필요
//	public void tutoral01Receiver(String str) {
//		System.out.println(str + "recv2");
//	}
	
	/* ===================================================================
		RabbitMQ - tutorial 3
	==================================================================== */
//	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name="ex01",type=ExchangeTypes.FANOUT),value= @Queue(name="que02")))
//	public void receiver(String msg) {
//		System.out.println(msg);
//	}

	/* ===================================================================
		RabbitMQ - tutorial 4
	==================================================================== */
//	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name="ex02",type=ExchangeTypes.DIRECT), value=@Queue(name="que02"), key="black"))
//	public void receiver_black(String msg) {
//		System.out.println(msg);
//	}
//
//	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name="ex02",type=ExchangeTypes.DIRECT), value=@Queue(name="que02"), key="green"))
//	public void receiver_green(String msg) {
//		System.out.println(msg);
//	}
//
//	// 키를 한번에 쓸 수도 있다!
//	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name="ex02",type=ExchangeTypes.DIRECT), value=@Queue(name="que02"), key={"black", "green"}))
//	public void receiver_all(String msg) {
//		System.out.println(msg);
//	}
	
	/* ===================================================================
		RabbitMQ - tutorial 5
		잘 안될 경우 rabbitmq에서 바인딩 되어 있는 Routing Key를 확인한다.
		이전에 바인딩 된 key가 저장되어 있을 수 있다.
	==================================================================== */
//	@RabbitListener(
//		bindings = @QueueBinding(exchange = @Exchange(name="ex03",type=ExchangeTypes.TOPIC),
//			value = @Queue(name="que02"),
////			key={"*.*.*.rabbit", "lazy.#"}
////			key="lazy.#"
////			key="#.lazy"
////			key="#.lazy.#"
//			key="*.*.*"
//		)
//	)
//	public void receiver(String msg) {
//		System.out.println(msg);
//	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person implements Serializable {
	String name;
	int age;
}