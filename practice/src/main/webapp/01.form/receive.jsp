<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//이 안은 자바코드 작성이 가능하다
	//- 서버에서 해야할 일이 있다면 여기에 작성
	//- 해야할 일 : 전달되는 데이터(pokemonName, pokemonType)을 수신
	//- 수신 명령 : request.getParaeter("이름") ---> 문자열 반환
	int pokemonNo = Integer.parseInt(request.getParameter("pokemonNo"));
	String pokemonName = request.getParameter("pokemonName");
	String pokemonType = request.getParameter("pokemonType");
	
	//만약 이곳에 데이터베이스 저장 코드가 있었다면? 등록이 완료되었을 것!
%>

<h2>전달된 번호 = <%=pokemonNo%></h2>
<h2>전달된 이름 = <%=pokemonName%></h2>
<h2>전달된 속성 = <%=pokemonType%></h2>


