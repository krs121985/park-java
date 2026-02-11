<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/views/template/header.jsp"></jsp:include>


<div class="container w-600">
	
	<div class="cell center">
		<h2>몬스터 신규 등록 완료</h2>
	</div>
	
	<div class="cell mt-40 center">
		<a href="./add.jsp" class="form-btn positive">
			<i class="fa-solid fa-rotate-right"></i>
			<span>다시 등록하기</span>
		</a>
		<a href="./list.jsp" class="form-btn neutral">
			<i class="fa-solid fa-list"></i>
			<span>목록으로 이동</span>
		</a>
	</div>
	
</div>


<jsp:include page="/views/template/footer.jsp"></jsp:include>