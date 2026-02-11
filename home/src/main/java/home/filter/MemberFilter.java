package home.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//비회원의 접근을 차단하는 필터
//- 회원 전용 페이지를 대상으로 설정
//- 회원은 통과, 비회원은 차단 + 로그인 페이지로 리다이렉트
public class MemberFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//로그인 상태라는 것은 세션에 loginId와 loginLevel이라는 항목이 존재한다는 것을 의미 (loginId만 봐도 확인 가능)
		//(주의) JSP와 다르게 Filter는 주어진 메소드 내에서 모든 것을 해결해야 한다 (없는건 꺼내거나 만들어야함)
		HttpSession session = request.getSession();//세션 정보를 추출
		
		String loginId = (String)session.getAttribute("loginId");
		boolean member = loginId != null;
		
		if(member) {//회원이면 통과
			chain.doFilter(request, response);
		}
		else {//비회원이면 차단 + 로그인페이지로 이동
			response.sendRedirect("/home/views/member/login.jsp");//절대경로로 작성
		}
	}
}







