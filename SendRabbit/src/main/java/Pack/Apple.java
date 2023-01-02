package Pack;

import java.io.Serializable;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
			"routingKey01", // 라우팅 설정 시 key 값
			"LION"			// 보낼 데이터
		);
		return "redirect:/"; // 원래 페이지 refresh
	}

	@RequestMapping("/t3")
	public String func03() {
		System.out.println("func03 Call");
		
		rabbitTemplate.convertAndSend(
				"exchange01",	// rabbit의 exchange와 매핑된다.
				"routingKey01", // 라우팅 설정 시 key 값
				new Person("호랑이", 10)	// 보낼 데이터
				);
		return "redirect:/"; // 원래 페이지 refresh
	}
	
	/* ===================================================================
		RabbitMQ - tutorial 1
	==================================================================== */
	@RequestMapping("/t4")
	public String func04() {
		System.out.println("func04 Call");
		String str = "Hello World!!";
		
		rabbitTemplate.convertAndSend(
				"hello",	// queue 이름
				str			// 보내는 메시지
		);
		return "redirect:/"; // 원래 페이지 refresh
	}

	/* ===================================================================
		RabbitMQ - tutorial 2
	==================================================================== */
	@RequestMapping("/t5")
	public String func05() {
		System.out.println("func05 Call");
		String str = "Work Queues!!";
		
		rabbitTemplate.convertAndSend(
				"hello",	// queue 이름
				str
				);
		return "redirect:/"; // 원래 페이지 refresh
	}
	
	/* ===================================================================
		RabbitMQ - tutorial 3
	==================================================================== */
	int count1 = 1;
	@RequestMapping("/t6")
	public String f6() {
		System.out.println("f6 call");
		
		rabbitTemplate.convertAndSend(
				"ex01",
				"",
				"tutorial03 : " + count1++
				);
		
		return "redirect:/";
	}
	
	/* ===================================================================
		RabbitMQ - tutorial 4
	==================================================================== */
	int count2 = 1;
	@RequestMapping("/t71")
	public String func71() {
		System.out.println("func71 Call");
		String msg = "오렌지 : " + count2++;
		rabbitTemplate.convertAndSend(
			"ex02",
			"orange",
			msg
		);
		return "redirect:/";
	}
	
	@RequestMapping("/t72")
	public String func72() {
		System.out.println("func71 Call");
		String msg = "블랙 : " + count2++;
		rabbitTemplate.convertAndSend(
			"ex02",
			"black",
			msg
		);
		return "redirect:/";
	}
	
	@RequestMapping("/t73")
	public String func73() {
		System.out.println("func71 Call");
		String msg = "그린 : " + count2++;
		rabbitTemplate.convertAndSend(
			"ex02",
			"green",
			msg
		);
		return "redirect:/";
	}
	
	@RequestMapping("/t74")
	public String func74() {
		System.out.println("func74 Call");
		String msg = "오렌지 : " + count2++;
		rabbitTemplate.convertAndSend(
				"ex02",
				"orange",
				msg);
		
		msg = "블랙 : " + count2++;
		rabbitTemplate.convertAndSend(
			"ex02",
			"black",
			msg);
		
		msg = "그린 : " + count2++;
		rabbitTemplate.convertAndSend(
			"ex02",
			"green",
			msg);
		
		return "redirect:/";
	}
	
	/* ===================================================================
		RabbitMQ - tutorial 5
	==================================================================== */
	@RequestMapping("/t8")
	public String func8() {
		System.out.println("func71 Call");
		String msg = "호랑이";
		rabbitTemplate.convertAndSend(
			"ex03",
			"lazy.banana.elephant.show",
			msg
		);
		return "redirect:/";
	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person implements Serializable {
	String name;
	int age;
}