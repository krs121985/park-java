package home.servlet.member;

import java.io.IOException;

import home.beans.HistoryDao;
import home.beans.HistoryDto;
import home.beans.MemberDao;
import home.beans.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/views/member/login.do")
public class MemberLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//전송데이터 수신
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(req.getParameter("memberId"));
			memberDto.setMemberPw(req.getParameter("memberPw"));
			
			MemberDao memberDao = new MemberDao();
			MemberDto findMemberDto = memberDao.selectOne(memberDto.getMemberId()); 
			//로그인이 되려면...?
			//1. 아이디가 존재해야 한다 (findMemberDto가 null이 아니면 된다)
			//2. 비밀번호가 같아야 한다
			boolean valid = findMemberDto != null && findMemberDto.getMemberPw().equals(memberDto.getMemberPw());
			
			if(valid) {//로그인 성공
				//(+추가) 이 회원이 만약 차단된 상태라면 로그인에 성공했더라도 로그인 처리를 하지 않고 차단 페이지로 강제 이동
				if(findMemberDto.getMemberBlock().equals("Y")) {//차단된 회원이라면
					resp.sendRedirect("./block.jsp");//차단 페이지로 강제 리다이렉트
					return;
				}
				
				//(+추가) 아이디 저장하기 여부를 체크해서 쿠키를 생성하거나 삭제
				String remember = req.getParameter("remember");//아이디 저장하기 체크여부(!=null이면 체크)
				if(remember != null) {//아이디 저장하기를 체크했다면 → 쿠키 생성
					Cookie cookie = new Cookie("saveId", findMemberDto.getMemberId());//쿠키 생성
					cookie.setMaxAge(4*7*24*60*60);//만료시간 설정(초)
					resp.addCookie(cookie);//사용자에게 쿠키 발송
				}
				else {//아이디 저장하기를 체크하지 않았다면 → 쿠키 삭제
					Cookie cookie = new Cookie("saveId", findMemberDto.getMemberId());//쿠키 생성
					cookie.setMaxAge(0);//만료시간 설정(초)
					resp.addCookie(cookie);//사용자에게 쿠키 발송
				}
			
				//(+추가) 회원의 로그인 기록을 추가
				HistoryDto historyDto = new HistoryDto();
				historyDto.setHistoryMember(findMemberDto.getMemberId());//아이디
				historyDto.setHistoryOrigin(req.getRemoteAddr());//클라이언트의 주소
				historyDto.setHistoryAgent(req.getHeader("User-Agent"));//클라이언트 기기정보
				HistoryDao historyDao = new HistoryDao();
				historyDao.insert(historyDto);
				
				//(+추가) 회원의 최종로그인 시각을 갱신시키도록 처리
				memberDao.updateMemberLogin(findMemberDto.getMemberId()); 
				
				
				//로그인에 성공했다는 표시를 남기기 위해 세션에 데이터를 저장
				//- 세션에 데이터는 최소한으로 저장할 수 있어야 한다 (아이디, 등급)
				HttpSession session = req.getSession();
				session.setAttribute("loginId", findMemberDto.getMemberId());
				session.setAttribute("loginLevel", findMemberDto.getMemberLevel());
				
				resp.sendRedirect("/home");//상대경로로 쓰면 `../../index.jsp` 라서 매우 불편
			}
			else {//로그인 실패
				resp.sendRedirect("./login.jsp?error");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
