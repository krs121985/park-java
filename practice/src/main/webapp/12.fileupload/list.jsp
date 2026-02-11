<%@page import="practice.beans.AttachDto"%>
<%@page import="java.util.List"%>
<%@page import="practice.beans.AttachDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	AttachDao attachDao = new AttachDao();
	List<AttachDto> list = attachDao.selectList();
%>


<% for(AttachDto attachDto : list) { %>
	<div><%=attachDto%></div>
	<img src="./download.do?attachNo=<%=attachDto.getAttachNo()%>" width="200">
	<a href="./download.do?attachNo=<%=attachDto.getAttachNo()%>" download="<%=attachDto.getAttachName()%>">다운로드</a>
<% } %>






