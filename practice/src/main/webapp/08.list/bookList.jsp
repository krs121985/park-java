<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//도서 목록 조회
	String sql = "select * from book order by book_no asc";

	//연결 및 조회 코드
	Class.forName("oracle.jdbc.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "the01", password = "the01";
	Connection conn = DriverManager.getConnection(url, username, password);
	
	PreparedStatement ps = conn.prepareStatement(sql);
	//홀더 없으므로 pass
	
	ResultSet rs = ps.executeQuery();//조회용 명령
%>
<!Doctype HTML>
<html>
	<head>
		<title>도서 목록</title>
	</head>
	<body>
		<h1>도서 목록</h1>
		
		<table border="1" width="600">
			<thead>
				<tr>
					<th>도서번호</th>
					<th>도서명</th>
					<th>도서장르</th>
					<th>페이지수</th>
					<th>판매가</th>
					<th>대여상태</th>
				</tr>
			</thead>
			<tbody align="center">
				<%while(rs.next()) { %>
				<tr>
					<td><%=rs.getInt("book_no")%></td>
					<td><%=rs.getString("book_title")%></td>
					<td><%=rs.getString("book_genre")%></td>
					<td><%=rs.getInt("book_pagecount")%></td>
					<td><%=rs.getInt("book_price")%></td>
					<td><%=rs.getString("book_status")%></td>
				</tr>		
				<%} %>
			</tbody>
		</table>
	</body>
</html>
<%
	rs.close();
	ps.close();
	conn.close();
%>