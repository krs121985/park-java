<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSP의 자동 수신기능을 이용해서 7개의 정보를 수신 -->
<jsp:useBean id="memberDto" class="home.beans.MemberDto"></jsp:useBean>
<jsp:setProperty property="*" name="memberDto"/>
<% 
	//보낸 정보에 아이디는 없으므로 아이디는 세션에서 추출하여 설정
	String loginId = (String)session.getAttribute("loginId");

	//(주의) 비밀번호 검사는 무조건 자바코드로 해야한다 (암호화 등 다양한 업그레이드가 가능)
	MemberDao memberDao = new MemberDao();
	MemberDto findMemberDto = memberDao.selectOne(loginId);
	boolean valid = memberDto.getMemberPw().equals(findMemberDto.getMemberPw());
	if(valid == false) {//비밀번호가 불일치하면 ?error를 붙여서 이전 페이지로 리다이렉트
		response.sendRedirect("./change.jsp?error");
		return;
	}
	
	memberDto.setMemberId(loginId);//아이디를 채워준 뒤
	boolean result = memberDao.update(memberDto);//정보를 변경하도록 처리
	
	response.sendRedirect("./mypage.jsp");//마이페이지로 리다이렉트
%>




