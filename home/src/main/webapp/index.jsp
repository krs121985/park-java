<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- header.jsp를 불러오는 코드 -->
<jsp:include page="/views/template/header.jsp"></jsp:include>

<!-- 기존에 만들었던 단위 화면을 이곳에 배치 -->
<div class="container w-600 mt-50 mb-50">
    <div class="cell center">
        <h2>Welcome!</h2>
    </div>
    <div class="cell">
        <img src="https://picsum.photos/600/400">
    </div>
</div>

<!-- overlay.jsp를 불러오는 코드 -->
<jsp:include page="/views/template/overlay.jsp"></jsp:include>

<!-- footer.jsp를 불러오는 코드 -->
<jsp:include page="/views/template/footer.jsp"></jsp:include>


