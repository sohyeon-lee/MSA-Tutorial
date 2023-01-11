package Pack;

import javax.servlet.http.HttpServletRequest;

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
	public Object run() throws ZuulException { // filtering 메서드 
		log.info("Auth Post run");
		RequestContext requestContext = RequestContext.getCurrentContext();
		String bearerToken = requestContext.getRequest().getHeader("Authorization");
		log.info(bearerToken);
		if(!(StringUtils.hasText(bearerToken)) || !(bearerToken.equals("Bearer 3000"))) {
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(406);
			requestContext.setResponseBody("auth fail.");
			requestContext.getResponse().setHeader("Content-Type", "text/plain;charset=UTF-8");
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