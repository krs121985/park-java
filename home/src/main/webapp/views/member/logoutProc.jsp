<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자에게 보이지 않으며 세션에 저장된 로그인 정보만 제거하는 페이지
	session.removeAttribute("loginId");//사용자의 세션에 저장된 loginId라는 이름의 데이터를 지우세요
	session.removeAttribute("loginLevel");//사용자의 세션에 저장된 loginLevel이라는 이름의 데이터를 지우세요
	
	response.sendRedirect("/home");//메인 페이지로 리다이렉트 
%>