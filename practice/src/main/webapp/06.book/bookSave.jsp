<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 처리 및 결과화면 -->
<%//scriptlet(스크립트릿)
	
	//파라미터 수신
	String bookTitle = request.getParameter("bookTitle");
	String bookGenre = request.getParameter("bookGenre");
	int bookPagecount = Integer.parseInt(request.getParameter("bookPagecount"));
	int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
	String bookStatus = request.getParameter("bookStatus");
	
	//등록 코드
	Class.forName("oracle.jdbc.OracleDriver");
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "the01";
	String password = "the01";
	Connection conn = DriverManager.getConnection(url, username, password);
	
	String sql = "insert into book("
					+"book_no, book_title, book_genre, book_pagecount," 
					+"book_price, book_status)"
				+"values(book_seq.nextval, ?, ?, ?, ?, ?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, bookTitle);//1번홀더에 bookTitle을 문자열로 설정
	ps.setString(2, bookGenre);//2번홀더에 bookGenre를 문자열로 설정
	ps.setInt(3, bookPagecount);//3번홀더에 bookPagecount를 숫자로 설정
	ps.setInt(4, bookPrice);//4번홀더에 bookPrice를 숫자로 설정
	ps.setString(5, bookStatus);//5번홀더에 bookStatus를 문자열로 설정
	
	ps.executeUpdate();
	
	ps.close();
	conn.close();
%>

<h1>도서 등록이 완료되었습니다</h1>
<h2><a href="./bookAdd.jsp">추가 등록하기</a></h2>








