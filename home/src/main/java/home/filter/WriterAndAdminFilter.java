package home.filter;

import java.io.IOException;

import home.beans.BoardDao;
import home.beans.BoardDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/views/board/delete.do")
public class WriterAndAdminFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpSession session = request.getSession();
			String loginId = (String)session.getAttribute("loginId");
			if(loginId == null) {//비회원 차단
				response.sendError(401);
				return;
			}
			
			String loginLevel = (String)session.getAttribute("loginLevel");
			boolean isAdmin = loginLevel != null && loginLevel.equals("관리자");
			if(isAdmin) {//관리자는 통과
				chain.doFilter(request, response);
				return;
			}
			
			//올바른 파라미터인지 검사
			if(request.getParameter("boardNo") == null) {//boardNo라는 이름의 파라미터가 없다면
				response.sendError(400);//400(Bad request, 부적합한 형식의 요청)
				return;
			}
			
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			
			BoardDao boardDao = new BoardDao();
			BoardDto boardDto = boardDao.selectOne(boardNo);
			//존재하지 않는 글인 경우 차단
			if(boardDto == null) {
				response.sendError(404);
				return;
			}
			
			//작성자가 "탈퇴한 사용자"인 경우 차단
			if(boardDto.getBoardWriter() == null) {
				response.sendError(403);
				return;
			}
			
			//작성자가 현재 사용자와 일치하지 않으면
			if(boardDto.getBoardWriter().equals(loginId) == false) {
				response.sendError(403);
				return;
			}
			
			//모두 통과했다면 작성자 본인이라고 간주하여 통과
			chain.doFilter(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
			response.sendError(500);
		}
	}
}




