package Pack;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bpp")
class ZuulMsa02Controller {
	
	@PostMapping
	public String f1() {
		System.out.println("bpp");
		return "bpp";
	}
}
