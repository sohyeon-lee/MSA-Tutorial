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
//		try {Thread.sleep(5000);} catch (Exception e) {}
//		System.out.println(str + "recv1");
//	}
	
//	@RabbitListener(queues = "hello") // RecvRabbitApplication 클래스에서 queue 빈 생성 필요
//	public void receive(String in, Channel channel, Message str) {
//		try {Thread.sleep(5000);} catch (Exception e) {}
//		System.out.println(in);
//		long tag = str.getMessageProperties().getDeliveryTag();
//		
//		try {
//			channel.basicAck(tag, false);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		System.out.println(str + "recv1");
//	}
	
	/* ===================================================================
		RabbitMQ - tutorial 3
	==================================================================== */
//	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name="ex01", type=ExchangeTypes.FANOUT), value= @Queue(name="que01")))
//	public void receiver(String msg) {
//		System.out.println(msg);
//	}

	/* ===================================================================
		RabbitMQ - tutorial 4
	==================================================================== */
//	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name="ex02",type=ExchangeTypes.DIRECT), value=@Queue(name="que01"), key="orange"))
//	public void receiver_orange(String msg) {
//		System.out.println(msg);
//	}

	/* ===================================================================
		RabbitMQ - tutorial 5
	==================================================================== */
	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name="ex03", type=ExchangeTypes.TOPIC), value = @Queue(name="que01"), key = "*.orange.*"))
	public void receiver(String msg) {
		System.out.println(msg);
	}

	/* ===================================================================
		RabbitMQ - tutorial 6(String)
	==================================================================== */
//	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name="ex04", type=ExchangeTypes.DIRECT), value = @Queue(name="que04"), key = "key01"))
//	public String receiver(String msg) {
//		System.out.println(msg);
//		return msg + "RPC";
//	}

	/* ===================================================================
		RabbitMQ - tutorial 6(Object)
	==================================================================== */
//	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name="ex04", type=ExchangeTypes.DIRECT), value = @Queue(name="que04"), key = "key02"))
//	public Person receiver(Person person) {
//		System.out.println(person.toString());
//		return new Person("앵무새", 3000);
//	}
}


@Data
@NoArgsConstructor
@AllArgsConstructor
class Person implements Serializable {
	String name;
	int age;
}