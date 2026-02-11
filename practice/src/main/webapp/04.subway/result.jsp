<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 사용자가 보낸 데이터를 받아서 계산 후 출력하는 페이지 -->
<%
	int year = Integer.parseInt(request.getParameter("year"));
	int current = LocalDate.now().getYear();
	int age = current - year + 1;
	
	int price;
	if(age < 8 || age >= 65) price = 0;
	else if(age < 14) price = 550;
	else if(age < 20) price = 900;
	else price = 1550;
%>
<h2>당신의 나이는 <%=age%>세이고 요금은 <%=price%>원 입니다</h2>







