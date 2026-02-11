<%@page import="java.text.DecimalFormat"%>
<%@page import="practice.beans.BookDto"%>
<%@page import="practice.beans.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int bookNo = Integer.parseInt(request.getParameter("bookNo"));

	BookDao bookDao = new BookDao();
	BookDto bookDto = bookDao.selectOne(bookNo);
	
	DecimalFormat df = new DecimalFormat("#,###");
%>

<h1>도서 정보</h1>

<table border="1" width="400">
	<tbody>
		<tr>
			<th width="25%">번호</th>
			<td><%=bookDto.getBookNo()%></td>
		</tr>
		<tr>
			<th>도서명</th>
			<td><%=bookDto.getBookTitle()%></td>
		</tr>
		<tr>
			<th>장르</th>
			<td><%=bookDto.getBookGenre()%></td>
		</tr>
		<tr>
			<th>페이지수</th>
			<td><%=df.format(bookDto.getBookPagecount())%> page</td>
		</tr>
		<tr>
			<th>판매가</th>
			<td><%=df.format(bookDto.getBookPrice())%>원</td>
		</tr>
		<tr>
			<th>현재상태</th>
			<td><%=bookDto.getBookStatus()%></td>
		</tr>
	</tbody>
</table>










