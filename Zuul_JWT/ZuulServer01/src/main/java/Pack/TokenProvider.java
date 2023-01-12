package Pack;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

/**
 * JWT 생성 및 검증
 * 
 * @author isohyeon
 *
 */
@Slf4j
@Component
public class TokenProvider {
private static final String SECRET_KEY = "1UQJ5XsXc8ZtKZdfqsJZmrVEyHH4jvoJpmzkEsIjqki4F9HwxWSuwnjuwkKxtcFcNKM9gLhAPm3TfhJxYEEfoNvUQlLvnnE5JrlQ";
	
	/**
	 * JWT Token 생성 메서드
	 * 
	 * @param uesrId 유저 아이디
	 * @return JWT Token
	 */
	public String create(String userId) {
		// 기한 지금으로부터 1일로 설정
		Date expiryDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
//		Long expiryDate = 1L;
		
		// JWT Token 생성
		return Jwts.builder()
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				// payload에 들어갈 내용
				.setSubject(userId) // sub
				.setIssuer("zuul test app") // iss
				.setIssuedAt(new Date()) // iat
//				.setExpiration(new Date(new Date().getTime() + expiryDate)) // exp
				.setExpiration(expiryDate) // exp
				.compact();
	}
	
	/**
	 * JWT Token 검증(디코딩, 파싱 및 위조여부 확인) 메서드
	 * 
	 * @param token 검증하려는 JWT Token
	 * @return 검증된 userId(subject) 또는 예외
	 */
	public String validateAndGetUserId(String token) {
		// parseClaimsJws 메서드가 Base 64로 디코딩 및 파싱
		// 즉, 헤더와 페이로드를 setSigningKey로 넘어온 비밀키를 이용해 서명 후, token의 서명과 비교.
		// 위조되지 안히았다면 페이로드(Claims) 리턴, 위조라면 예외를 날림
		// 그 중 우리는 userId가 필요하므로 getBody를 호출한다.
		Claims claims = Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
}
