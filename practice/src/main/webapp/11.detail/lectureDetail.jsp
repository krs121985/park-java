<%@page import="java.text.DecimalFormat"%>
<%@page import="practice.beans.LectureDto"%>
<%@page import="practice.beans.LectureDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int lectureNo = Integer.parseInt(request.getParameter("lectureNo"));
	LectureDao lectureDao = new LectureDao();
	LectureDto lectureDto = lectureDao.selectOne(lectureNo);
	
	DecimalFormat df = new DecimalFormat("#,###");
%>

<h1>강좌 상세 정보</h1>

<table border="1" width="400">
	<tbody>
		<tr>
			<th width="25%">번호</th>
			<td><%=lectureDto.getLectureNo()%></td>
		</tr>
		<tr>
			<th>강좌명</th>
			<td><%=lectureDto.getLectureSubject()%></td>
		</tr>
		<tr>
			<th>분야</th>
			<td><%=lectureDto.getLectureCategory()%></td>
		</tr>
		<tr>
			<th>시간</th>
			<td>
				<%=df.format(lectureDto.getLectureDuration())%>H
			</td>
		</tr>
		<tr>
			<th>수강료</th>
			<td>
				<%=df.format(lectureDto.getLecturePrice())%>원
				(1시간당 <%=df.format(lectureDto.getLecturePricePerHour())%>원)
			</td>
		</tr>
		<tr>
			<th>강의유형</th>
			<td><%=lectureDto.getLectureType()%></td>
		</tr>
	</tbody>
</table>









