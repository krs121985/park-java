<%@page import="home.service.AttachService"%>
<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자에게 보이지 않게 회원삭제 및 로그아웃 처리
	String loginId = (String)session.getAttribute("loginId");
	String memberPw = request.getParameter("memberPw");
	
	MemberDao memberDao = new MemberDao();
	
	//비밀번호 일치하는지 검사
	MemberDto memberDto = memberDao.selectOne(loginId);
	boolean valid = memberDto.getMemberPw().equals(memberPw);
	if(valid == false) {
		response.sendRedirect("./exit.jsp?error");
		return;
	} 
	
	//(+추가) 파일이 있다면 제거해야 한다
	int attachNo = memberDao.findImage(loginId);//없으면 -1 나오게 되어있음
	if(attachNo != -1) {//이미지 있음
		AttachService attachService = new AttachService();
		attachService.delete(attachNo);
	}
	
	//회원 삭제
	boolean result = memberDao.delete(loginId); 
	
	//로그아웃
	session.removeAttribute("loginId");
	session.removeAttribute("loginLevel");
	
	//완료 페이지로 이동
	response.sendRedirect("./exitResult.jsp");
%>
