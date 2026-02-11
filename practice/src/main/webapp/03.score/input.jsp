<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 사용자에게 최초에 보여줄 입력화면 -->
<h1>성적 계산기</h1>
<form action="./calculate.jsp">
	이름 <input type="text" name="name"> <br><br>
	국어 <input type="number" name="korean" min="0" max="100">점 <br><br>
	영어 <input type="number" name="english" min="0" max="100">점 <br><br>
	수학 <input type="number" name="math" min="0" max="100">점 <br><br>
	<button type="submit">계산하기</button>
</form>