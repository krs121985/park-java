<%@page import="home.beans.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int bookNo = Integer.parseInt(request.getParameter("bookNo"));
	BookDao bookDao = new BookDao();
	boolean result = bookDao.delete(bookNo); 
	response.sendRedirect("./list.jsp");
%>