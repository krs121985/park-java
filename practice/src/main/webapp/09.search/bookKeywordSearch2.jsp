<%@page import="practice.beans.BookDto"%>
<%@page import="java.util.List"%>
<%@page import="practice.beans.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//파라미터(keyword)를 받아서 검색인지 목록인지 판단하여 처리
	String keyword = request.getParameter("keyword");
	boolean search = keyword != null;
	
	//데이터베이스 연결 및 조회
	BookDao bookDao = new BookDao();
	List<BookDto> list = bookDao.selectList(keyword);
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
<%	for(BookDto bookDto : list) { %>
		<tr>
			<td><%=bookDto.getBookNo()%></td>
			<td><%=bookDto.getBookGenre()%></td>
			<td><%=bookDto.getBookTitle()%></td>
			<td><%=bookDto.getBookPagecount()%></td>
			<td><%=bookDto.getBookPrice()%></td>
			<td><%=bookDto.getBookStatus()%></td>
		</tr>
<% 	} %>
	</tbody>
</table>






