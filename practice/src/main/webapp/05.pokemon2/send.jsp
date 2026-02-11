<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 사용자 입력 및 전송 페이지 -->

<h1>포켓몬 등록</h1>

<form action="./receive.jsp">
	이름 : <input type="text" name="pokemonName"> <br><br>
	속성 : <input type="text" name="pokemonType"> <br><br>
	<button type="submit">등록하기</button>
</form>