package Pack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.core.publisher.Mono;

/* ===================================================================
 	ex01
==================================================================== */
//@RestController
//@RequestMapping("/app1")
//class AppController {
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
	ex02
==================================================================== */
/*
@RestController
@RequestMapping("/app2/{num}")
public class AppController {
	
	@Autowired
	private RestTemplate restTemplate; // 빈으로 등록해줘야 한다. (main파일에서 빈 등록함)
	
//	@GetMapping("")
//	public String f1(@PathVariable String num) {
//		System.out.println("app2");
//		
//		// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다.
//		String str = restTemplate.getForObject("http://localhost:8082/bpp2/{num}", String.class, num+999); 
//		
//		return "[app2 : " + num + "] [" + str + "]";
//	}

	@GetMapping("")
	public String f1(@PathVariable String num) {
		System.out.println("app2");
		
		// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다.
		Integer data =  restTemplate.getForObject("http://localhost:8082/bpp2/{num}", Integer.class, num+999); 
		
		return "[app2 : " + num + "] [" + (data+1) + "]";
	}
}
*/

/* ===================================================================
	ex03 - 객체
==================================================================== */
/*
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Person {
	String name;
	int age;
}

@RestController
@RequestMapping("/app2/{num}")
public class AppController {
	
	@Autowired
	private RestTemplate restTemplate; // 빈으로 등록해줘야 한다. (main파일에서 빈 등록함)

	@GetMapping("")
	public String f1(@PathVariable String num) {
		System.out.println("app2");
		
		// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다.
		Person data =  restTemplate.getForObject("http://localhost:8082/bpp2/{num}", Person.class, num+999); 
		
		return "app : " + data.getName() + data.getAge();
	}
}
*/

/* ===================================================================
	ex04 - 배열
==================================================================== */
/*
@RestController
@RequestMapping("/app2/{num}")
public class AppController {
	
	@Autowired
	private RestTemplate restTemplate; // 빈으로 등록해줘야 한다. (main파일에서 빈 등록함)
	
//	// 숫자 배열
//	@GetMapping("")
//	public String f1(@PathVariable String num) {
//		
//		// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다.
//		Integer[] data =  restTemplate.getForObject("http://localhost:8082/bpp2/{num}", Integer[].class, num+999); 
//		String result = "";
//		for (Integer value : data) {
//			result += (value+" ");
//		}
//		return "app : " + result;
//	}

//	// 문자열 배열
//	@GetMapping("")
//	public String f1(@PathVariable String num) {
//		
//		// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다.
//		String[] data =  restTemplate.getForObject("http://localhost:8082/bpp2/{num}", String[].class, num+999); 
//		String result = "";
//		for (String value : data) {
//			result += (value+" ");
//		}
//		return "app : " + result;
//	}
	
//	// 객체 배열
//	@GetMapping("")
//	public String f1(@PathVariable String num) {
//		
//		// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다.
//		Person[] data =  restTemplate.getForObject("http://localhost:8082/bpp2/{num}", Person[].class, num+999);
//		for (String value : data) {
//			result += (value+" ");
//		}
//		return "app : ";
//	}
	
//	// 컬렉션
//	@GetMapping("")
//	public String f1(@PathVariable String num) {
//		
//		// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다.
//		ResponseEntity<Integer[]> data =  restTemplate.getForEntity("http://localhost:8082/bpp2/{num}", Integer[].class, num+999); 
//		String result = "";
//		for (Integer value : data.getBody()) {
//			result += (value + " ");
//		}
//		return "app : " + result;
//	}
	
//  // 컬렉션 - 객체
//	@GetMapping("")
//	public String f1(@PathVariable String num) {
//		
//		// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다.
//		ResponseEntity<Person[]> data =  restTemplate.getForEntity("http://localhost:8082/bpp2/{num}", Person[].class, num+999); 
//		
//		Person person = new Person();
//		for(int i=0; i<data.getBody().length; i++) {
//			person.setName(data.getBody()[i].getName());
//			person.setName(data.getBody()[i].getName());
//			result += data.getBody()[i].getName() + " ";
//		}
//		return "app : " + result;
//	}
}

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Person {
	String name;
	int age;
}
*/

/* ===================================================================
	ex05 - 데이터 여러개 주고받기
==================================================================== */
//@RestController
//@RequestMapping("/app2/{num}")
//public class AppController {
//	
//	@Autowired
//	private RestTemplate restTemplate; // 빈으로 등록해줘야 한다. (main파일에서 빈 등록함)
//
//	@GetMapping("")
//	public String f1(@PathVariable String num) {
//		System.out.println("app2");
//		
//		// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다.
//		Integer data =  restTemplate.getForObject("http://localhost:8082/bpp2/{a1}/{a2}", Integer.class, 777, 888); 
//		
//		return "app : " + data;
//	}
//}

/* ===================================================================
	ex06 - WebClient (논블로킹의 사용)
==================================================================== */
//@RestController
//@RequestMapping("/app3")
//public class AppController {
//
//	@GetMapping("")
//	public Mono<String> f1() {
//		WebClient client =  WebClient.create();
//		
//		// 논블로킹, 바로 return 시켜야 한다.
////		Mono<String> m = client
////							.get()
////							.uri("http://localhost:8082/bpp2")
////							.retrieve()
////							.bodyToMono(String.class);
//		
//		return client
//				.get()
//				.uri("http://localhost:8082/bpp2")
//				.retrieve()
//				.bodyToMono(String.class);
//	}
//}

/* ===================================================================
	ex06 - WebClient (블로킹의 사용)
==================================================================== */
//@RestController
//@RequestMapping("/app3")
//public class AppController {
//	
//	@GetMapping("")
//	public String f1() {
//		WebClient client =  WebClient.create();
//		
//		// 논블로킹 -> 블로킹
//		// 개발용으로 사용한다.
//		String data = client
//							.get()
//							.uri("http://localhost:8082/bpp2")
//							.retrieve()
//							.bodyToMono(String.class)
//							.block();
//		return data;
//	}
//}

/* ===================================================================
	ex07 - WebClient (객체)
==================================================================== */
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//class Person {
//	String name;
//	int age;
//}
//
//@RestController
//@RequestMapping("/app3")
//public class AppController {
//	
//	@GetMapping("")
//	public String f1() {
//		WebClient client =  WebClient.create();
//		
//		// 논블로킹 -> 블로킹
//		// 개발용으로 사용한다.
//		Person data = client
//							.get()
//							.uri("http://localhost:8082/bpp2")
//							.retrieve()
//							.bodyToMono(Person.class)
//							.block();
//		return data.getName() + data.getAge();
//	}
//}

/* ===================================================================
	ex08 - WebClient (리스트)
==================================================================== */
//@RestController
//@RequestMapping("/app3")
//public class AppController {
//	
//	@GetMapping("")
//	public String f1() {
//		WebClient client =  WebClient.create();
//		
//		// 논블로킹 -> 블로킹
//		// 개발용으로 사용한다.
//		Integer[] data = client
//				.get()
//				.uri("http://localhost:8082/bpp2")
//				.retrieve()
//				.bodyToMono(Integer[].class)
//				.block();
//		
//		String str = "";
//		for (Integer value : data) {
//			str += (value + " ");
//		}
//		return str;
//	}
//}

/* ===================================================================
	ex09 - WebClient (비동기 통신 코드 분리)
==================================================================== */
//@RestController
//@RequestMapping("/app3")
//public class AppController {
//	
//	// 비동기 통신 코드 분리
//	public Mono<String> f2() {
//		WebClient client =  WebClient.create();
//		return client
//				.get()
//				.uri("http://localhost:8082/bpp2")
//				.retrieve()
//				.bodyToMono(String.class);
//	}
//	
//	@GetMapping("")
//	public String f1() {
//		Mono<String> result = f2();
//		result.subscribe((value)->{
//			System.out.println("나중 실행 ...");
//			System.out.println(value);
//		});
//		System.out.println("먼저 실행 ...");
//		return null;
//	}
//}

@RestController
@RequestMapping("/app3")
public class AppController {
	
	// 비동기 통신 코드 분리
	public Mono<String> f2() {
		WebClient client =  WebClient.create();
		return client
				.get()
				.uri("http://localhost:8082/bpp2")
				.retrieve()
				.bodyToMono(String.class);
	}
	
	@GetMapping("")
	public String f1() {
		Mono<String> result = f2();
		result.subscribe((value)->{
			System.out.println("나중 실행 ...");
			System.out.println(value);
		});
		System.out.println("먼저 실행 ...");
		return null;
	}
}
