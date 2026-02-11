<%@page import="java.sql.ResultSet"%>
<%@page import="practice.util.JdbcUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//진행방향
	//1. 주소에 있는 keyword라는 파라미터를 읽는다
	//2. 키워드를 이용해서 포켓몬스터 이름 검색 구문을 생성
	//- select * from pokemon where pokemon_name = ? order by pokemon_no asc
	//3. 조회 결과를 화면에 표시
	
	
	//1
	String keyword = request.getParameter("keyword");

	//2
	String sql = "select * from pokemon where pokemon_name = ? order by pokemon_no asc";
	PreparedStatement ps = JdbcUtil.getWorker(sql);
	ps.setString(1, keyword);
	
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









