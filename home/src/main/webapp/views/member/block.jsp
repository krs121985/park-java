<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/views/template/header.jsp"></jsp:include>

<div class="container w-600">
	<div class="cell center red">
		<h2>로그인 제한 안내</h2>
	</div>
	<div class="cell center">
		현재 귀하의 계정에 대한 로그인이 차단되어 있습니다.<br>
		문의사항이 있으실 경우 고객센터(000-0000)으로 연락주시기 바랍니다.
	</div>
	<div class="cell center mt-40">
<!-- 		<img src="/home/resources/images/not-allow.png" width="30%"> -->
		<i class="fa-solid fa-ban red fa-10x fa-fade"></i>
	</div>
</div>

<jsp:include page="/views/template/footer.jsp"></jsp:include>