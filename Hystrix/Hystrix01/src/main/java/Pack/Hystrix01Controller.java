package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Controller
public class Hystrix01Controller {
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

@RestController
@RequestMapping("/app1")
class AppController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	// @HystrixCommand : 장애가 발생하는지 감시한다.
	// fallbackMethod : 장애 발생 시 실행할 메서드
	// RestTemplate을 사용할 때는 장애 발생을 대처하기 위해서 hystrix을 같이 사용해줘야 한다.
	@GetMapping("/{num}")
	@HystrixCommand(fallbackMethod = "catcat", commandProperties = {
			@HystrixProperty(
					name = "execution.isolation.thread.timeoutInMilliseconds", 
					value = "500"), // 기본 타임아웃 설정(응답을 기다리는 시간)
			@HystrixProperty(
					name="circuitBreaker.errorThresholdPercentage",
					value = "25"), // 25%이상 문제가 발생하면 circuit 오픈
			@HystrixProperty(
					name = "metrics.rollingStats.timeInMilliseconds",
					value = "10000"), // 최근 10초 동안 n회 이상 호출되면 통과
			@HystrixProperty(
					name = "circuitBreaker.requestVolumeThreshold",
					value = "3"), // 위의 속성의 n을 3으로 설정
			@HystrixProperty(
					name = "circuitBreaker.sleepWindowInMilliseconds",
					value = "8000") // circuit 오픈 유지 시간
			})
	public String f1(@PathVariable Integer num) {
		// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다. (ex. 광고 영상 데이터를 주세요.)
		String str = restTemplate.getForObject("http://localhost:8082/bpp1/" + num, String.class); 
		return "app1 : " + str;
	}
	
	public String catcat(Integer num, Throwable t) {
		System.out.println("circuit 알림 : " + t);
		return "기본 광고를 시작합니다.";
	}
}