<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 사용자가 전송한 데이터 수신 및 등록 처리 -->

<%
	//파라미터 수신
	String lectureSubject = request.getParameter("lectureSubject");
	String lectureCategory = request.getParameter("lectureCategory");
	int lectureDuration = Integer.parseInt(request.getParameter("lectureDuration"));
	int lecturePrice = Integer.parseInt(request.getParameter("lecturePrice"));
	String lectureType = request.getParameter("lectureType");
	
	//데이터베이스 등록
	Class.forName("oracle.jdbc.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "the01";
	String password = "the01";
	Connection conn = DriverManager.getConnection(url, username, password);
	
	String sql = "insert into lecture("
					+"lecture_no, lecture_subject, lecture_category, "
					+"lecture_duration, lecture_price, lecture_type"
				+") values(lecture_seq.nextval, ?, ?, ?, ?, ?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, lectureSubject);
	ps.setString(2, lectureCategory);
	ps.setInt(3, lectureDuration);
	ps.setInt(4, lecturePrice);
	ps.setString(5, lectureType);
	
	ps.executeUpdate();
	
	ps.close();
	conn.close();
%>


<h1>강좌 등록이 완료되었습니다</h1>





