<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//목록을 불러와서 출력하는 코드
	String sql = "select * from pokemon";

	//데이터베이스 연결 및 명령 전송 도구 생성 (등록과 동일)
	Class.forName("oracle.jdbc.OracleDriver");
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "the01";
	String password = "the01";
	Connection conn = DriverManager.getConnection(url, username, password);//연결 생성
	
	PreparedStatement ps = conn.prepareStatement(sql);//명령 실행도구
	
	//(주의) 조회는 등록과 반대의 작업이기 때문에 실행 명령과 처리 과정이 다름
	ResultSet rs = ps.executeQuery();//데이터를 불러오는 조회 명령 (ResultSet은 조회 결과 표)
	
	while(rs.next()) {//ResultSet에서 다음 줄로 이동한 뒤 데이터가 존재한다면 
	%>
	<h1>
		<%=rs.getInt("pokemon_no")%>, 
		<%=rs.getString("pokemon_name")%>, 
		<%=rs.getString("pokemon_type")%> 
	</h1>	
	<%
	}
	
	//정리
	rs.close();
	ps.close();
	conn.close();
%>





