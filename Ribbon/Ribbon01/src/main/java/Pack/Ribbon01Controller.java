package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
public class Ribbon01Controller {
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

/* ===================================================================
	리본사용(X): >> 8082 // 안됨
==================================================================== */
@RestController
@RequestMapping("/app1")
class AppController1 {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("")
	public String f1() {
		System.out.println("app1");
		
		// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다.
		String str = restTemplate.getForObject("http://localhost:8082/bpp1", String.class); 
		
		return "app1 : " + str;
	}
}

/* ===================================================================
	리본사용(O): >> 8083, 8084
==================================================================== */
@RestController
@RequestMapping("/app2")
class AppController2 {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("")
	public String f1() {
		System.out.println("app2");
		// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다.
		String str = restTemplate.getForObject("http://tiger/bpp1", String.class); 
		return "app1 : " + str;
	}
}