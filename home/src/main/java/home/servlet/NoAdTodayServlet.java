package home.servlet;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/views/noAdToday.do")
public class NoAdTodayServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//오늘 자정까지 남은 초를 계산해서 maxAge로 설정한 뒤 쿠키를 생성한다
			LocalDateTime current = LocalDateTime.now();
			LocalDateTime midnight = current.toLocalDate().plusDays(1L).atStartOfDay();
			//Duration을 이용하여 current와 midnight의 차이를 초로 계산
			Duration d = Duration.between(current, midnight);
			long seconds = d.toSeconds();
			
			Cookie cookie = new Cookie("mainPop", "hello");//값은 상관없음
			cookie.setMaxAge((int)seconds);
			cookie.setPath("/home");//쿠키를 사용할 수 있는 엔드포인트 설정
			resp.addCookie(cookie);
			
			resp.sendRedirect("/home");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}






