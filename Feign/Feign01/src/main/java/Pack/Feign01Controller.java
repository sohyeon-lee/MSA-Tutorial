package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feign.hystrix.FallbackFactory;

/* ===================================================================
	RestTemplate 사용 - 빈 주석 해제 후 사용
==================================================================== */
//@RestController
//@RequestMapping("/app1")
//public class Feign01Controller {
//	
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	@GetMapping("")
//	public String f1() {
//		System.out.println(restTemplate.hashCode());
//		
//		// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다.
//		String str = restTemplate.getForObject("http://localhost:8082/bpp1", String.class); 
//		
//		return "app1 : " + str;
//	}
//}

/* ===================================================================
	Feign 사용 1 - 기본 사용
==================================================================== */
//@FeignClient(name = "monkey", url = "http://localhost:8082") // name 설정이 없으면 오류 발생. 임시로 적어놨음.
//interface TestClient {
//	@RequestMapping("/bpp1") // http://localhost:8082/bpp2 가 호출되면 myFunc 함수가 실행된다.
//	String myFunc();
//}
//
///*
//	// 구현체를 이렇게 작성했을 것이다~!
//	String myFunc() {
//		String str = restTemplate.getForObject("ip");
//	}
//*/
//
//@RestController
//@RequestMapping("/app2")
//class Feign01Controller {
//	
//	@Autowired
//	TestClient testClient; // FeignClient 어노테이션을 작성함으로써 자동으로 인터페이스의 구현체가 완성되었다. 따라서 autowired가 가능하다.
//	
//	@GetMapping("")
//	public String f1() {
//		System.out.println("app2");
//		String str = testClient.myFunc();
//		return "app2 : " + str;
//	}
//}

/* ===================================================================
	Feign 사용 2 - param 전송
==================================================================== */
//@FeignClient(name = "tiger", url = "http://localhost:8082") // name 설정이 없으면 오류 발생. 임시로 적어놨음.
//interface TestClient2 {
//	@RequestMapping("/bpp2/{num}") // http://localhost:8082/bpp2 가 호출되면 myFunc 함수가 실행된다. (myFunc -> bpp2)
//	String myFunc(@PathVariable int num);
//}
//
//@Service
//class TempService {
//	@Autowired
//	TestClient2 testClient;
//	
//	String collectionCommand(Integer productId) {
//		/*
//			db 접속 코드. 연산 코드 등등 ..
//		*/
//		String str = testClient.myFunc(3000);
//		return str;
//	}
//}
//
//@RestController
//@RequestMapping("/app2")
//class Feign01Controller {
//	@Autowired
//	TempService tempService; // FeignClient 어노테이션을 작성함으로써 자동으로 인터페이스의 구현체가 완성되었다. 따라서 autowired가 가능하다.
//	
//	@GetMapping("")
//	public String f1() {
//		System.out.println("app2");
//		String str = tempService.collectionCommand(3000);
//		return "app2 : " + str;
//	}
//}

/* ===================================================================
	Feign 사용 ex3
	- Eureka 함께 사용 
	- yml 파일에 Feign0002 추가
	- Feign0002 서버가 다운되면 whitelabel 오류가 발생한다. (그래서 hystrix가 필요하다)
==================================================================== */
//@FeignClient(name = "Feign0002") // Eureka 서버에 등록된 서비스 명
//interface TestClient {
//	@RequestMapping("/bpp1") // http://localhost:8082/bpp1 가 호출되면 myFunc 함수가 실행된다.
//	String myFunc();
//}
//
//@RestController
//@RequestMapping("/app2")
//class Feign01Controller {
//
//	@Autowired
//	TestClient testClient; // FeignClient 어노테이션을 작성함으로써 자동으로 인터페이스의 구현체가 완성되었다. 따라서 autowired가 가능하다.
//	
//	@GetMapping("")
//	public String f1() {
//		System.out.println("app2");
//		String str = testClient.myFunc();
//		return "app2 : " + str;
//	}
//}

/* ===================================================================
	Feign 사용 ex4 
	- hystrix 함께 사용
	- Feign0002 서버가 다운되도 장애가 전파되지 않는다.
==================================================================== */
@FeignClient(name = "Feign0002", fallbackFactory = FeignFactory.class) 
interface TestClient {
	@RequestMapping("/bpp3/{num}")
	String myFunc(@PathVariable int num); // http://localhost:8082/bpp3/{num} 가 호출되면 myFunc 함수가 실행된다.
}

@Component
class FeignFactory implements FallbackFactory<TestClient> {
	@Override
	public TestClient create(Throwable cause) {
		System.out.println("factory create call");
		
		return new TestClient() {
			@Override
			public String myFunc(@PathVariable int num) {
				return "Hystrix 발생함";
			}
		};
	}
}

@RestController
@RequestMapping("/app3")
class Feign01Controller {
	
	@Autowired
	TestClient testClient; // FeignClient 어노테이션을 작성함으로써 자동으로 인터페이스의 구현체가 완성되었다. 따라서 autowired가 가능하다.
	
	@GetMapping("/{num}")
	public String f1(@PathVariable int num) {
		System.out.println("app2");
		String str = testClient.myFunc(num);
		return "app2 : " + str;
	}
}