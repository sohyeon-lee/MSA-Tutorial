package Pack;

import java.util.LinkedList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* ===================================================================
	ex01
==================================================================== */
//@RestController
//@RequestMapping("/bpp1")
//class AppController {
//	@GetMapping("")
//	public String f1() {
//		return "호랑이";
//	}
//}

/* ===================================================================
	ex02
==================================================================== */
//@RestController
//@RequestMapping("/bpp2/{num}")
//public class AppController {
//
////	@GetMapping("")
////	public String f1(@PathVariable String num) {
////		return "호랑이 : " + num;
////	}
//
//	@GetMapping("")
//	public int f1(@PathVariable String num) {
//		return 1234 ;
//	}
//}

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
@RequestMapping("/bpp2/{num}")
public class AppController {
	
	@GetMapping("")
	public Person f1(@PathVariable String num) {
		return new Person("호랑이", 3333);
	}
}
*/
/* ===================================================================
	ex04 - 배열
==================================================================== */
/*
@RestController
@RequestMapping("/bpp2/{num}")
public class AppController {
	
 	// 숫자 배열
//	@GetMapping("")
//	public Integer[] f1(@PathVariable String num) {
//		Integer[] arr = {10, 20, 30};
//		return arr;
//	}

//	// 문자열 배열
//	@GetMapping("")
//	public String[] f1(@PathVariable String num) {
//		System.out.println(num);
//		String[] arr = {"사과", "배", "감"};
//		return arr;
//	}
	
// 	// 객체 배열
//	@GetMapping("")
//	public Person[] f1(@PathVariable String num) {
//		System.out.println(num);
//		Person[] arr = {
//				new Person("이소현1", 20),
//				new Person("이소현2", 20),
//				new Person("이소현3", 20),
//		};
//		return arr;
//	}
	
//	// 컬렉션
//	@GetMapping("")
//	public LinkedList<?> f1(@PathVariable String num) {
//		System.out.println(num);
//		LinkedList<Integer> li = new LinkedList<>();
//		li.add(1);
//		li.add(2);
//		li.add(3);
//		return li;
//	}
	
//	// 컬렉션 - 객체
//	@GetMapping("")
//	public LinkedList<?> f1(@PathVariable String num) {
//		System.out.println(num);
//		LinkedList<Person> li = new LinkedList<>();
//		li.add(new Person("이소현1", 20));
//		li.add(new Person("이소현2", 20));
//		li.add(new Person("이소현3", 20));
//		return li;
//	}
}

@Setter
@Getter
@ToString
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
//@RequestMapping("/bpp2")
//public class AppController {
//
//	@GetMapping("/{n1}/{n2}")
//	public Integer f1(@PathVariable int n1, @PathVariable int n2) {
//		System.out.println(n1 + n2);
//		return n1 + n2;
//	}
//}

/* ===================================================================
	ex06 - WebClient 사용
==================================================================== */
//@RestController
//@RequestMapping("/bpp2")
//class AppController{
//    @GetMapping("")
//    public String f1() {
//        System.out.println("bpp2");
//        return "코끼리";
//    }
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
//@RequestMapping("/bpp2")
//class AppController{
//    @GetMapping("")
//    public Person f1() {
//        return new Person("이소현", 27);
//    }
//}

/* ===================================================================
	ex08 - WebClient (리스트)
==================================================================== */
//@RestController
//@RequestMapping("/bpp2")
//class AppController{
//	@GetMapping("")
//	public LinkedList<Integer> f1() {
//		LinkedList<Integer> li = new LinkedList<>();
//		li.add(1000);
//		li.add(2000);
//		li.add(3000);
//		return li;
//	}
//}

/* ===================================================================
	ex09 - WebClient (비동기 통신 코드 분리)
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
//@RequestMapping("/bpp2")
//class AppController{
//	@GetMapping("")
//	public LinkedList<Integer> f1() {
//		LinkedList<Integer> li = new LinkedList<>();
//		li.add(1000);
//		li.add(2000);
//		li.add(3000);
//		return li;
//	}
//}