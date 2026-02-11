<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/views/template/header.jsp"></jsp:include>

<div class="container w-600">
	<div class="cell">
		<h2>도서 등록 완료</h2>
	</div>
	<div class="cell">
		도서 등록이 완료되었습니다.<br>
		아래 버튼을 눌러 다음 작업을 선택하세요!
	</div>
	<div class="cell mt-40">
		<a href="./add.jsp" class="form-btn positive">
			<i class="fa-solid fa-rotate-right"></i>
			<span>다시 등록하기</span>
		</a>
		<a href="./list.jsp" class="form-btn neutral">
			<i class="fa-solid fa-list"></i>
			<span>목록으로 이동하기</span>
		</a>
	</div>
</div>


<jsp:include page="/views/template/footer.jsp"></jsp:include>