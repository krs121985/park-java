<%@page import="practice.beans.LectureDto"%>
<%@page import="java.util.List"%>
<%@page import="practice.beans.LectureDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String keyword = request.getParameter("keyword");
	
	LectureDao lectureDao = new LectureDao();
	List<LectureDto> list = lectureDao.selectList(keyword);
%>

<h1>강좌 검색</h1>

<form>
	<input type="text" name="keyword" placeholder="검색어 입력" value="<%=keyword == null ? "" : keyword%>">
	<button type="submit">검색</button>
</form>

<table border="1" width="800">
	<thead>
		<tr>
			<th>번호</th>
			<th>강좌명</th>
			<th>주제</th>
			<th>시간</th>
			<th>강의료</th>
			<th>유형</th>
		</tr>
	</thead>
	<tbody>
		<%for(LectureDto lectureDto : list) { %>
		<tr>
			<td><%=lectureDto.getLectureNo()%></td>
			<td><%=lectureDto.getLectureSubject()%></td>
			<td><%=lectureDto.getLectureCategory()%></td>
			<td><%=lectureDto.getLectureDuration()%>H</td>
			<td><%=lectureDto.getLecturePrice()%>원</td>
			<td><%=lectureDto.getLectureType()%></td>
		</tr>
		<%} %>
	</tbody>
</table>







