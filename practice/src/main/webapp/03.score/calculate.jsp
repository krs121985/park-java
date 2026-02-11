<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 사용자가 전송한 데이터에 대한 처리 결과 -->
<%
	//계산 영역
	String name = request.getParameter("name");
	int korean = Integer.parseInt(request.getParameter("korean"));
	int english = Integer.parseInt(request.getParameter("english"));
	int math = Integer.parseInt(request.getParameter("math"));
	
	int total = korean + english + math;
	double average = total / 3d;
	DecimalFormat df = new DecimalFormat("#,###.##");
%>

<!-- 출력 영역 -->
<h1><%=name%>님의 성적 정보</h1>
<h2>- 총점 : <%=total%>점</h2>
<h2>- 평균 : <%=df.format(average)%>점</h2>



