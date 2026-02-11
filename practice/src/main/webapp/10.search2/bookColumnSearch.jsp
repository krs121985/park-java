<%@page import="practice.beans.BookDto"%>
<%@page import="java.util.List"%>
<%@page import="practice.beans.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String column = request.getParameter("column");
	String keyword = request.getParameter("keyword");
	
	BookDao bookDao = new BookDao();
	List<BookDto> list = bookDao.selectList(column, keyword);
%>

<h1>도서 검색</h1>

<form>
	<select name="column">
		<option value="book_title" <%=column!=null&&column.equals("book_title") ? "selected" : ""%>>도서명</option>
		<option value="book_genre" <%=column!=null&&column.equals("book_genre") ? "selected" : ""%>>장르</option>
		<option value="book_status" <%=column!=null&&column.equals("book_status") ? "selected" : ""%>>대여상태</option>
	</select>
	<input type="text" name="keyword" placeholder="검색" value="<%=keyword == null ? "" : keyword%>">
	<button type="submit">검색</button>
</form>


<h2>결과 수 : <%=list.size()%>개</h2>
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








