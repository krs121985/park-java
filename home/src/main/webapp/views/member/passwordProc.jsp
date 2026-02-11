<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자에게 보이지 않는 비밀번호 검사 및 변경 페이지
	String loginId = (String)session.getAttribute("loginId");
	String memberPw = request.getParameter("memberPw");
	String changePw = request.getParameter("changePw");
	
	//1. 비밀번호 비교
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.selectOne(loginId);
	boolean valid = memberDto.getMemberPw().equals(memberPw);
	if(valid == false){//비밀번호가 맞지 않으면 
		response.sendRedirect("./password.jsp?error");
		return;
	}
	
	//2. 비밀번호 변경
	memberDao.updateMemberPw(loginId, changePw); 
	
	//만약 로그아웃까지 시키고 싶다면
	//session.removeAttribute("loginId");
	//session.removeAttribute("loginLevel");
	
	//3. 완료 페이지로 이동
	response.sendRedirect("./passwordResult.jsp");
%>














