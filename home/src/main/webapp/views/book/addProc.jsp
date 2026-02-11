<%@page import="home.beans.BookDao"%>
<%@page import="home.beans.BookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//전송되는 데이터가 몇개인지 확인해서 모두 받아야 함
	//- 도서명, 장르, 페이지수, 판매가, 대여상태 총 5가지 (번호는 안옴)
	BookDto bookDto = new BookDto();
	bookDto.setBookTitle(request.getParameter("bookTitle"));//수신이름이 input의 name과 같아야 함
	bookDto.setBookGenre(request.getParameter("bookGenre"));
	bookDto.setBookPagecount(Integer.parseInt(request.getParameter("bookPagecount")));//숫자
	bookDto.setBookPrice(Integer.parseInt(request.getParameter("bookPrice")));
	bookDto.setBookStatus(request.getParameter("bookStatus"));
	
	BookDao bookDao = new BookDao();
	bookDao.insert(bookDto); 
	
	response.sendRedirect("./addResult.jsp");
%>