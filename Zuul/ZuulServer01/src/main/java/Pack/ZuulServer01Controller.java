package Pack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuulServer01Controller {
	@GetMapping("/")
	public String func00() {
		System.out.println("Apple class Call");
		
		return "index";
	}
}
