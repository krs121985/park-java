<%@page import="java.sql.ResultSet"%>
<%@page import="practice.util.JdbcUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//검색어가 없으면 목록을, 검색어가 있으면 검색을 수행하도록 처리
	
	//1
	String keyword = request.getParameter("keyword");

	//2
	String sql;
	if(keyword == null) {
		sql = "select * from pokemon order by pokemon_no asc";
	}
	else {
		sql = "select * from pokemon where pokemon_name = ? order by pokemon_no asc";
	}
	
	PreparedStatement ps = JdbcUtil.getWorker(sql);
	if(keyword != null) {
		ps.setString(1, keyword);
	}
	
	ResultSet rs = ps.executeQuery();//조회용 명령
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
		<%while(rs.next()) { %>
		<tr>
			<td><%=rs.getInt("pokemon_no")%></td>
			<td><%=rs.getString("pokemon_name")%></td>
			<td><%=rs.getString("pokemon_type")%></td>
		</tr>
		<%} %>
	</tbody>
</table>

<%
	JdbcUtil.close(ps);
%>









