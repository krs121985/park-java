<%@page import="practice.beans.LectureDto"%>
<%@page import="java.util.List"%>
<%@page import="practice.beans.LectureDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String column = request.getParameter("column");
	String keyword = request.getParameter("keyword");
	
	LectureDao lectureDao = new LectureDao();
	List<LectureDto> list = lectureDao.selectList(column, keyword);
%>

<h1>강좌 목록</h1>

<form>
	<select name="column">
		<option value="lecture_subject" <%=column!=null&&column.equals("lecture_subject") ? "selected":""%>>강좌명</option>
		<option value="lecture_category" <%=column!=null&&column.equals("lecture_category") ? "selected":""%>>강의주제</option>
		<option value="lecture_type" <%=column!=null&&column.equals("lecture_type") ? "selected":""%>>강의형태</option>		
	</select>
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
			<td>
				<a href="/practice/11.detail/lectureDetail.jsp?lectureNo=<%=lectureDto.getLectureNo()%>">
				<%=lectureDto.getLectureSubject()%>
				</a>
			</td>
			<td><%=lectureDto.getLectureCategory()%></td>
			<td><%=lectureDto.getLectureDuration()%>H</td>
			<td><%=lectureDto.getLecturePrice()%>원</td>
			<td><%=lectureDto.getLectureType()%></td>
		</tr>
		<%} %>
	</tbody>
</table>




