package Pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Hystrix02Controller {
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
@RequestMapping("/bpp1")
class AppController {
	@GetMapping("/{num}")
	public String f1(@PathVariable Integer num) {
		System.out.println("bpp");
		// 장애를 발생시키기 위함
		try {Thread.sleep(num);} catch (InterruptedException e) {e.printStackTrace();}
		return "서비스 광고를 시작합니다.";
	}
}
