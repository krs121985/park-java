package home.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/views/admin/*"})
public class AdminFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpSession session = request.getSession();//HTTP세션 추출
			String loginLevel = (String)session.getAttribute("loginLevel");
			boolean isAdmin = loginLevel != null && loginLevel.equals("관리자");
			
			if(isAdmin) {//관리자라면
				chain.doFilter(request, response);//통과
			}
			else {
				response.sendError(403);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			response.sendError(500);
		}
	}
}






