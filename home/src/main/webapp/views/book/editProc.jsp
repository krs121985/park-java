<%@page import="home.beans.BookDao"%>
<%@page import="home.beans.BookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자 화면에는 보이지 않는 수정 처리 페이지
	BookDto bookDto = new BookDto();
	bookDto.setBookNo(Integer.parseInt(request.getParameter("bookNo")));
	bookDto.setBookTitle(request.getParameter("bookTitle"));
	bookDto.setBookGenre(request.getParameter("bookGenre"));
	bookDto.setBookPagecount(Integer.parseInt(request.getParameter("bookPagecount")));
	bookDto.setBookPrice(Integer.parseInt(request.getParameter("bookPrice")));
	bookDto.setBookStatus(request.getParameter("bookStatus"));
	
	BookDao bookDao = new BookDao();
	boolean result = bookDao.update(bookDto); 
	
	response.sendRedirect("./detail.jsp?bookNo="+bookDto.getBookNo());
%>