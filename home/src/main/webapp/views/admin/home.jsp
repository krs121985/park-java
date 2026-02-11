<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/views/template/header.jsp"></jsp:include>

<div class="container w-400 mt-50">
	<div class="cell center">
		<h2>관리자 페이지</h2>
	</div>
	
	<div class="cell mt-40">
		<a href="./member/history.jsp" class="form-btn positive w-100">로그인 이력 조회</a>
	</div>
	<div class="cell">
		<a href="./member/history2.jsp" class="form-btn positive w-100">로그인 이력 조회(+페이징)</a>
	</div>
	<div class="cell">
		<a href="#" class="form-btn positive w-100">회원 관리</a>
	</div>		
	<div class="cell">
		<a href="#" class="form-btn positive w-100">홈페이지 현황</a>
	</div>	
</div>

<jsp:include page="/views/template/footer.jsp"></jsp:include>