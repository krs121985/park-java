<%@page import="practice.beans.PokemonDto"%>
<%@page import="java.util.List"%>
<%@page import="practice.beans.PokemonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//검색어가 없으면 목록을, 검색어가 있으면 검색을 수행하도록 처리
	String keyword = request.getParameter("keyword");

	PokemonDao pokemonDao = new PokemonDao();
	List<PokemonDto> list = pokemonDao.selectList(keyword);
%>

<!-- 검색창 -->
<form action="./pokemonKeywordSearch.jsp">
	<input type="text" name="keyword" placeholder="검색어 입력" value="<%=keyword == null ? "" : keyword%>">
	<button type="submit">검색</button>
</form>

<!-- 결과 표시용 테이블 -->
<table border="1" width="400">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>속성</th>
		</tr>
	</thead>
	<tbody align="center">
		<%for(PokemonDto pokemonDto : list){ %>
		<tr>
			<td><%=pokemonDto.getPokemonNo()%></td>
			<td><%=pokemonDto.getPokemonName()%></td>
			<td><%=pokemonDto.getPokemonType()%></td>
		</tr>
		<%} %>
	</tbody>
</table>










