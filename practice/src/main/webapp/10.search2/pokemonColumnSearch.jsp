<%@page import="practice.beans.PokemonDto"%>
<%@page import="java.util.List"%>
<%@page import="practice.beans.PokemonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//항목을 고르고 키워드를 입력하는 검색을 처리하는 방법
	//- select형태의 column이란 이름으로 항목을 전달받는다 (ex : pokemon_name)
	//- input형태의 keyword란 이름으로 검색어를 전달받는다 (ex : 피카)
	
	//파라미터 수신
	String column = request.getParameter("column");
	String keyword = request.getParameter("keyword");
	
	//검색
	PokemonDao pokemonDao = new PokemonDao();
	List<PokemonDto> list = pokemonDao.selectList(column, keyword);
%>


<h1>포켓몬 검색</h1>

<form>
	<select name="column">
		<option value="pokemon_name" <%=column != null && column.equals("pokemon_name") ? "selected" : ""%>>몬스터명</option>
		<option value="pokemon_type" <%=column != null && column.equals("pokemon_type") ? "selected" : ""%>>몬스터속성</option>
	</select>
	<input type="text" name="keyword" value="<%=keyword == null ? "" : keyword%>">
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

