<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
    
<%
	//설정에서 isErrorPage="true"로 설정하면 마치 try~catch의 catch 블록처럼 페이지가 변한다
	//exception이란 이름의 객체를 사용할 수 있도록 허용되며 이 안에는 예외 정보가 들어있다
	//exception에 들어있는 진짜 원인(cause)를 추출하여 이를 가지고 판단하여 추가 작업을 지시
	if(exception.getCause() != null && exception.getCause().toString().contains("ORA-")) {
		System.out.println("**** 데이터베이스 처리 문제발생 ****");
	}
%>

<jsp:include page="/views/template/header.jsp"></jsp:include>

<div class="container w-800 mt-50 mb-50"> 
	<div class="cell center red">
		<h2>일시적인 서버 문제가 발생했습니다</h2>
	</div>
	<div class="cell center">
		잠시 후 다시 이용해주시기 바랍니다.<br>
		문제가 지속될 경우 고객센터에 문의 바랍니다.
	</div>
	<div class="cell center mt-40">
		<img src="https://picsum.photos/800/400" width="100%">
	</div>
</div>

<jsp:include page="/views/template/footer.jsp"></jsp:include>