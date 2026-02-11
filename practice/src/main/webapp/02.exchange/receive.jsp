<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//send.jsp에서 전송한 내용을 수신
	//- usd란 이름의 파라미터를 숫자 형태로 수신
	double usd = Double.parseDouble(request.getParameter("usd"));
	double ratio = 1467.69;
	
	double krw = usd * ratio;
	DecimalFormat df = new DecimalFormat("#,###.##");//3자리마다 콤마 + 소수점 2자리 제한
%>

<!-- 사용자가 볼 수 있도록 표시(System.out.println과 역할이 같음) --> 
<h2><%=usd%>달러에 대한 예상 환전 금액은 <%=df.format(krw)%>원 입니다</h2>