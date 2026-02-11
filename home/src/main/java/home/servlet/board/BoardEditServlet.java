package home.servlet.board;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import home.beans.BoardDao;
import home.beans.BoardDto;
import home.util.CompareUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/views/board/edit.do")
public class BoardEditServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//정보 수신(4개 - boardNo, boardHead, boardTitle, boardContent)
			BoardDto boardDto = new BoardDto();
			BeanUtils.populate(boardDto, req.getParameterMap());
			
			//(+추가) 관리자가 아닌데 공지사항을 등록하려고 하면 차단
			HttpSession session = req.getSession();
			if(CompareUtil.equals(boardDto.getBoardHead(), "공지")) {//공지사항이라면
				String loginLevel = (String)session.getAttribute("loginLevel");//권한을 꺼내어
				if(CompareUtil.equals(loginLevel, "관리자") == false) {//관리자가 아니면
					resp.sendError(403);
					return;
				}
			}
			
			//수정 처리
			BoardDao boardDao = new BoardDao();
			boolean result = boardDao.update(boardDto);
			
			//리다이렉트
			resp.sendRedirect("./detail.jsp?boardNo="+boardDto.getBoardNo());
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
