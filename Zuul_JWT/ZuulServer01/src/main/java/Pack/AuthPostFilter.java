package Pack;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
class AuthPostFilter extends ZuulFilter {
	private final String FILTER_TYPE = "post";
    private final int FILTER_ORDER = 1;
    private TokenProvider tokenProvider;
    
	public AuthPostFilter(TokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}

	@Override
	public boolean shouldFilter() {
		log.info("Auth Post shouldFilter");
		RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest req = context.getRequest();
        String uri = req.getRequestURI();
        
        // 로그인을 하는 api에서는 비활성화를 시킴.
        boolean excludeFiltering = uri.matches("/app.*");
        return excludeFiltering; // true일 경우 run() 실행.
	}

	@Override
	public Object run() throws ZuulException { // filtering 메서드 
		log.info("Auth Post run");
		RequestContext context = RequestContext.getCurrentContext();
		
		try {
			// http 상태 코드 비교
			if (context.getResponseStatusCode() == HttpStatus.UNAUTHORIZED.value()) {
				context.setResponseBody("login fail.");
				context.getResponse().setHeader("Content-Type", "text/plain;charset=UTF-8");
				return null;
			}
			
			// http body에 담긴 로그인 정보 확인
			InputStream responseDataStream = context.getResponseDataStream();
			String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));
			
			String token = tokenProvider.create(responseData); // JWT 생성
			context.setResponseBody(token); // JWT 반환
			context.getResponse().setHeader("Content-Type", "text/plain;charset=UTF-8");
		} catch (Exception e) {
			log.error("JWT create error");
		}
		
		return null;
	}

	@Override
	public String filterType() {
		return FILTER_TYPE;
	}

	@Override
	public int filterOrder() {
		return FILTER_ORDER;
	}
}