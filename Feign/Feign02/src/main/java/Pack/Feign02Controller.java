package Pack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* ===================================================================
	Feign 사용 ex01, ex03 
==================================================================== */
@RestController
@RequestMapping("/bpp1")
class Feign02Controller1 {
	@GetMapping("")
	public String f1() {
		System.out.println("bpp1");
		return "bpp1";
	}
}

/* ===================================================================
	Feign 사용 ex02 - param 전송
==================================================================== */
@RestController
@RequestMapping("/bpp2")
class Feign02Controller2 {
	@GetMapping("/{num}")
	public String f1(@PathVariable Integer num) {
		System.out.println("bpp2");
		return "bpp2" + num;
	}
}

/* ===================================================================
	Feign 사용 ex04
==================================================================== */
@RestController
@RequestMapping("/bpp3")
class Feign02Controller3 {
	@GetMapping("/{num}")
	public String f1(@PathVariable int num) {
		System.out.println("bpp3" + num);
		try {
			Thread.sleep(num);
		} catch (Exception e) {}
		return "bpp3" + num;
	}
}
