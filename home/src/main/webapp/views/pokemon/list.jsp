<%@page import="home.beans.PokemonDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.PokemonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="pageVO" class="home.beans.PageVO"></jsp:useBean>
<jsp:setProperty property="*" name="pageVO"/>

<%
	PokemonDao pokemonDao = new PokemonDao();
	List<PokemonDto> list = pokemonDao.selectListByPaging(pageVO);
	int count = pokemonDao.count(pageVO);
%>    
    
    
<jsp:include page="/views/template/header.jsp"></jsp:include>

<div class="container w-600">
	<!-- 제목 -->
	<div class="cell center">
		<h2>포켓몬 목록</h2>
	</div>
	
	<!-- 검색창 -->
	<div class="cell center">
		<form>
			<div class="flex-box" style="justify-content: center">
				<select name="column" class="form-input me-10">
					<option value="pokemon_name" <%=pageVO.getColumnValue().equals("pokemon_name") ? "selected" : ""%>>이름</option>
					<option value="pokemon_type" <%=pageVO.getColumnValue().equals("pokemon_type") ? "selected" : ""%>>속성</option>
				</select>	
				<input type="text" name="keyword" placeholder="검색어" class="form-input me-10"
						value="<%=pageVO.getKeywordValue()%>">
				<button type="submit" class="form-btn positive">
					<i class="fa-solid fa-magnifying-glass"></i>
					<span>검색</span>
				</button>
			</div>
		</form>
	</div>
	
	<!-- 등록버튼 -->
	<div class="cell right">
		<a href="./add.jsp" class="form-btn neutral">
			<i class="fa-solid fa-plus"></i>
			<span>신규 등록</span>
		</a>
	</div>
	
	<!-- 결과표시창 -->
	<div class="cell">
		<table class="grid hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>속성</th>
				</tr>
			</thead>
			<tbody class="center">
				<%for(PokemonDto pokemonDto : list) { %>
				<tr>
					<td><%=pokemonDto.getPokemonNo()%></td>
					<td>
						<!-- 이름을 클릭하여 상세페이지로 이동하도록 링크 구현 -->
						<a href="./detail.jsp?pokemonNo=<%=pokemonDto.getPokemonNo()%>">
							<%=pokemonDto.getPokemonName()%>
						</a>
					</td>
					<td><%=pokemonDto.getPokemonType()%></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	
	<!-- pagination -->
	<div class="cell">
		<jsp:include page="/views/template/pagination.jsp">
			<jsp:param name="count" value="<%=count%>"/>
		</jsp:include>
	</div>
	
</div>

<jsp:include page="/views/template/footer.jsp"></jsp:include>













