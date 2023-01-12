package Pack;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
class Member {
	String id;
	String pw;
}

@RestController
@RequestMapping("/app")
public class ZuulMsa01Controller {

	@PostMapping
	public ResponseEntity<?> f1(@RequestBody Member member) {
		System.out.println(member.toString());
	    boolean isCorrect = member.getPw().equals("1234");
	    
		if(isCorrect) {
			return ResponseEntity
					.ok()
					.body(member.getId());
		}
		return ResponseEntity
				.status(HttpStatus.UNAUTHORIZED)
				.body("fail");
	}
}
