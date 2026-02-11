<%@page import="java.sql.ResultSet"%>
<%@page import="practice.util.JdbcUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//파라미터(keyword)를 받아서 검색인지 목록인지 판단하여 처리
	String keyword = request.getParameter("keyword");
	boolean search = keyword != null;
	
	//데이터베이스 연결 및 조회
	String sql;
	if(search)	sql = "select * from book where book_title = ? order by book_no asc";
	else 		sql = "select * from book order by book_no asc";
	
	PreparedStatement ps = JdbcUtil.getWorker(sql);
	if(search) ps.setString(1, keyword);
	
	ResultSet rs = ps.executeQuery();
%>

<h1>도서 정보</h1>

<form action="./bookKeywordSearch.jsp">
	<input type="text" name="keyword" placeholder="책 제목 입력" value="<%=search ? keyword : ""%>">
	<button type="submit">검색</button>
</form>

<table border="1" width="600">
	<thead>
		<tr>
			<th>번호</th>
			<th>장르</th>
			<th>제목</th>
			<th>페이지</th>
			<th>가격</th>
			<th>상태</th>
		</tr>
	</thead>
	<tbody>
<%	while(rs.next()) { %>
		<tr>
			<td><%=rs.getInt("book_no")%></td>
			<td><%=rs.getString("book_genre")%></td>
			<td><%=rs.getString("book_title")%></td>
			<td><%=rs.getInt("book_pagecount")%></td>
			<td><%=rs.getInt("book_price")%></td>
			<td><%=rs.getString("book_status")%></td>
		</tr>
<% 	} %>
	</tbody>
</table>

<%
	JdbcUtil.close(ps);
%>





