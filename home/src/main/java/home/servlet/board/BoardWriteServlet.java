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

@WebServlet(urlPatterns = "/views/board/write.do")
public class BoardWriteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//보내는 데이터 자동수신 (새글일 때는 3개, 답글일 때는 4개)
			//- 새글 : boardHead, boardTitle, boardContent
			//- 답글 : boardHead, boardTitle, boardContent, boardParent
			BoardDto boardDto = new BoardDto();
			BeanUtils.populate(boardDto, req.getParameterMap());
			
			//번호 생성 및 작성자 추출
			BoardDao boardDao = new BoardDao();
			int boardNo = boardDao.sequence();
			
			HttpSession session = req.getSession();
			String loginId = (String)session.getAttribute("loginId");
			
			boardDto.setBoardNo(boardNo);//번호 설정
			boardDto.setBoardWriter(loginId);//작성자 설정
			
			//(+추가) 관리자가 아닌데 공지사항을 등록하려고 하면 차단
			if(CompareUtil.equals(boardDto.getBoardHead(), "공지")) {//공지사항이라면
				String loginLevel = (String)session.getAttribute("loginLevel");//권한을 꺼내어
				if(CompareUtil.equals(loginLevel, "관리자") == false) {//관리자가 아니면
					resp.sendError(403);
					return;
				}
			}
			
			//새글인 경우와 답글인 경우의 그룹, 상위글, 차수를 구분하여 계산
			if(boardDto.getBoardParent() == null) {//새글인 경우
				boardDto.setBoardGroup(boardNo);//생성한 글번호
				//boardDto.setBoardParent(null);//null
				//boardDto.setBoardDepth(0);//0
			}
			else {//답글인 경우
				BoardDto parentBoardDto = boardDao.selectOne(boardDto.getBoardParent());//원본글 모든정보 조회
				boardDto.setBoardGroup(parentBoardDto.getBoardGroup());//원본글 그룹번호
				//boardDto.setBoardParent(parentBoardDto.getBoardNo());//원본글번호, 이미 있음
				boardDto.setBoardDepth(parentBoardDto.getBoardDepth()+1);//원본글차수+1
			}
			
			//등록 처리
			boardDao.insert(boardDto);
			
			//상세 페이지로 리다이렉트
			//resp.sendRedirect("./list.jsp");
			resp.sendRedirect("./detail.jsp?boardNo="+boardNo);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}





