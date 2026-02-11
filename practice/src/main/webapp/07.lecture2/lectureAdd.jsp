<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 사용자가 볼 등록 화면 -->
<h1>강좌 등록</h1>

<form action="./lectureSave.jsp">
	강좌명 <input type="text" name="lectureSubject"> <br><br>
	강좌구분 
	<select name="lectureCategory">
		<option value="">선택하세요</option>
		<option>이론</option>
		<option>실습</option>
		<option>시험</option>
	</select> <br><br>	
	강좌시간
	<select name="lectureDuration">
		<%for(int i=30; i <= 300; i+=30) { %>
		<option><%=i%></option>
		<%} %>
	</select> <br><br>
	수강료 <input type="text" inputmode="numeric" name="lecturePrice"><br><br>
	강의유형
	<select name="lectureType">
		<option>오프라인</option>
		<option>온라인</option>
		<option>혼합</option>
	</select> <br><br>
	<button type="submit">강좌 등록하기</button>
</form>




