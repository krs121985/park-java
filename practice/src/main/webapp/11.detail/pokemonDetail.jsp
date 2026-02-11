<%@page import="practice.beans.PokemonDto"%>
<%@page import="practice.beans.PokemonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//기본키를 수신하여 데이터를 조회하는 코드
	int pokemonNo = Integer.parseInt(request.getParameter("pokemonNo"));

	PokemonDao pokemonDao = new PokemonDao();
	PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
%>

<!-- 존재하는 경우 보여줄 페이지 작성 -->
<h1>포켓몬 상세정보</h1>

<table border="1" width="400">
	<tbody>
		<tr>
			<th width="25%">번호</th>
			<td><%=pokemonDto.getPokemonNo()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=pokemonDto.getPokemonName()%></td>
		</tr>
		<tr>
			<th>속성</th>
			<td><%=pokemonDto.getPokemonType()%></td>
		</tr>
	</tbody>
</table>




