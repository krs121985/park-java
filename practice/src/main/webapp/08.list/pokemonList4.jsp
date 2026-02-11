<%@page import="practice.beans.PokemonDto"%>
<%@page import="java.util.List"%>
<%@page import="practice.beans.PokemonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//이제부터는....
	//Pokemon 테이블을 쓰고싶으니까 PokemonDao를 만들어서 필요한 메소드를 부르면 끝!
	PokemonDao pokemonDao = new PokemonDao();
	List<PokemonDto> list = pokemonDao.selectList();
%>
	
<table border="1">
	<thead>
		<tr>
			<th>포켓몬번호</th>
			<th>포켓몬이름</th>
			<th>포켓몬속성</th>
		</tr>
	</thead>
	<tbody>
		<% for(PokemonDto pokemonDto : list) {%>
		<tr>
			<td><%=pokemonDto.getPokemonNo()%></td> 
			<td><%=pokemonDto.getPokemonName()%></td> 
			<td><%=pokemonDto.getPokemonType()%></td>
		</tr>
		<% } %>
	</tbody>
</table>





