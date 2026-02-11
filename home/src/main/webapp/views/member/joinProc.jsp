<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자에게 표시되지 않는 처리 코드
	
	//MemberDto memberDto = new MemberDto();
	//memberDto.setMemberId(request.getParameter("memberId"));
	//memberDto.setMemberPw(request.getParameter("memberPw"));
	//memberDto.setMemberNickname(request.getParameter("memberNickname"));
	//언제다하지...?
%>

<!-- 
	JSP에서 제공해주는 전용태그를 이용하면 객체 생성 및 데이터 수신을 쉽게 할 수 있다
	- jsp:useBean은 객체를 생성하는 태그 (6번줄 대체)
	- jsp:setProperty는 생성한 객체에 속성을 채우는 태그 (7번줄부터 대체)
	- 이렇게 생성한 객체는 자바 코드에서 사용 가능
	- (주의) DTO의 필드명과 input태그의 name이 정.확.하.게 같아야 한다
-->
<jsp:useBean id="memberDto" class="home.beans.MemberDto"></jsp:useBean>
<jsp:setProperty property="*" name="memberDto"/>

<%
	MemberDao memberDao = new MemberDao();
	memberDao.insert(memberDto);
	
	response.sendRedirect("./joinResult.jsp");
%>




