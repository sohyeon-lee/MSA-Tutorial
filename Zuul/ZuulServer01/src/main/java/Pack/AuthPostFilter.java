package Pack;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

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
    
	@Override
	public boolean shouldFilter() {
		log.info("Auth Post shouldFilter");
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
		RequestContext context = RequestContext.getCurrentContext();
		
		// body 값 가져오기
		// 제 생각에는 말이죠.. body 값 안가져오고 상태코드(ok, badrequest)로 로그인 성공, 실패 확인한 다음
		// 성공이면 토큰 생성을 하면 되지 않을까 싶네요..
		try {
			InputStream responseDataStream = context.getResponseDataStream();
			String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));
			System.out.println(responseData);
			
			if (responseData.equals("fail")) return null;
			
			// 여기서 JWT 생성 !!
			
			context.setResponseBody("3000"); // 토큰 3000이라고 가정
			context.getResponse().setHeader("Content-Type", "text/plain;charset=UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null; // run은 null만 리턴시켜야 한다. (강사님 said..)
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