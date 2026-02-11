<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 사용자가 볼 등록화면 -->

<h1>도서 등록</h1>
<form action="./bookSave.jsp">
	도서명 <input type="text" name="bookTitle"> <br><br>
	장르 
	<select name="bookGenre">
		<option value="">선택하세요</option>
		<option>기술</option>
		<option>교양</option>
		<option>시사</option>
		<option>동화</option>
		<option>미스터리</option>
		<option>정치</option>
		<option>경제</option>
	</select> <br><br>
	페이지수 <input type="text" inputmode="numeric" name="bookPagecount"> <br><br>
	판매가 <input type="text" inputmode="numeric" name="bookPrice"> <br><br>
	대여상태 
	<select name="bookStatus">
		<option>대여가능</option>
		<option>대여중</option>
		<option selected>대여불가</option>
	</select> <br><br>
	<button type="submit">도서 등록하기</button>
</form>
