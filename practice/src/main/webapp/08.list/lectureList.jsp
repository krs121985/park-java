<%@page import="java.sql.ResultSet"%>
<%@page import="practice.util.JdbcUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sql = "select * from lecture order by lecture_no asc";

	//미리 모듈화해둔 JdbcUtil을 불러서 한방에 연결 및 전송도구까지 획득
	PreparedStatement ps = JdbcUtil.getWorker(sql);
	//홀더 없음
	ResultSet rs = ps.executeQuery();
%>	
	<table border="1" width="600">
		<thead>
			<tr>
				<th>강좌코드</th>
				<th>카테고리</th>
				<th>강좌명</th>
				<th>강의시간</th>
				<th>수강료</th>
				<th>강의형태</th>
			</tr>	
		</thead>
		<tbody align="center">
			<%while(rs.next()){%> 
			<tr>
				<td><%=rs.getInt("lecture_no")%></td>
				<td><%=rs.getString("lecture_category")%></td>
				<td><%=rs.getString("lecture_subject")%></td>
				<td><%=rs.getInt("lecture_duration")%></td>
				<td><%=rs.getInt("lecture_price")%></td>
				<td><%=rs.getString("lecture_type")%></td>
			</tr>	
			<%}%>
		</tbody>
	</table>

<%	
	//종료
	JdbcUtil.close(ps); 
%>