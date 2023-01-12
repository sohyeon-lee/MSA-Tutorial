package Pack;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthPreFilter extends ZuulFilter {
	private final String FILTER_TYPE = "pre";
    private final int FILTER_ORDER = 1;
    private TokenProvider tokenProvider;
    
	public AuthPreFilter(TokenProvider tokenProvider) {
		super();
		this.tokenProvider = tokenProvider;
	}

	@Override
	public boolean shouldFilter() {
		log.info("Auth Pre shouldFilter");
		RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest req = context.getRequest();
        String uri = req.getRequestURI();
        
        // 로그인을 하는 api에서는 비활성화를 시킴.
        boolean excludeFiltering = uri.matches("/app.*");
        return !excludeFiltering; // true일 경우 run() 실행.
	}

	@Override
	public Object run() throws ZuulException {
		log.info("Auth Post run");
		RequestContext context = RequestContext.getCurrentContext();

		try {
			String token = parseBearerToken(context);
			String userId = tokenProvider.validateAndGetUserId(token); // 토큰 검증
			log.info("Authenticated user ID : " + userId);
		} catch (Exception e) {
			log.error("Auth Fail");
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
			context.setResponseBody("auth fail.");
			context.getResponse().setHeader("Content-Type", "text/plain;charset=UTF-8");
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
	
	/**
	 * Http 요청의 헤더를 파싱해 Authorization 토큰 리턴
	 * 
	 * @param request HTTP 요청
	 * @return Bearer 토큰
	 */
	private String parseBearerToken(RequestContext context) {
		// Http 요청의 헤더를 파싱해 Bearer 토큰을 리턴한다.
		String bearerToken = context.getRequest().getHeader(HttpHeaders.AUTHORIZATION);
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
			return bearerToken.substring(7);
		}
		return null;
	}
}