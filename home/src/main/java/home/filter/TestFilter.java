package home.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//필터(Filter) : 기존에 만들어둔 페이지에 전처리 혹은 후처리를 할 수 있는 도구 (간섭 도구라 표현)
//구현 순서
//1. 상속을 받는다 (jakarta.servlet.http.HttpFilter)
//2. 필요한 메소드를 재정의한다
//	- init() : 서버 시작 시 최초 1회만 실행되는 메소드 (초기설정 메소드)
//	- doFilter() : 사용자가 감시대상에 접근할 때마다 실행되는 메소드 (실제 작업 메소드)
//	- destroy() : 서버 종료 직전 1회만 실행되는 메소드 (최종정리 메소드)
//3. 필요한 코드 작성
//4. 적용시킬 주소 지정 (등록) - web.xml에 작성하거나 @WebFilter 애노테이션을 사용
public class TestFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, 
								FilterChain chain)
			throws IOException, ServletException {
		System.out.println("만세! 만세! 만세!");
		chain.doFilter(request, response);
	}
}





