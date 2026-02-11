<%@page import="home.util.CompareUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//MemberFilter 덕분에 회원만 들어오도록 처리되어서 null검사 안해도 됨(해도됨)
	String loginLevel = (String)session.getAttribute("loginLevel");
	//boolean isAdmin = loginLevel != null && loginLevel.equals("관리자");
	boolean isAdmin = CompareUtil.equals(loginLevel, "관리자");
%>

<jsp:include page="/views/template/header.jsp"></jsp:include>

<script type="text/javascript">
	function checkBoardTitle(){
		var target = document.querySelector("[name=boardTitle]");
		var valid = target.value.length > 0;
		target.classList.remove("success", "fail");
		target.classList.add(valid ? "success" : "fail");
		return valid;
	}
	function checkBoardContent(){
		var target = document.querySelector("[name=boardContent]");
		var valid = target.value.length > 0;
		target.classList.remove("success", "fail");
		target.classList.add(valid ? "success" : "fail");
		return valid;
	}
	function checkForm(){
		var boardTitleValid = checkBoardTitle();
		var boardContentValid = checkBoardContent();
		return boardTitleValid && boardContentValid;
	}
	
	function calculateBoardContent() {
		var textarea = document.querySelector("[name=boardContent]");
		
		// UTF-8 기준 byte 계산
		var encoder = new TextEncoder(); // 기본이 utf-8
		var bytes = encoder.encode(textarea.value);
		var count = bytes.length;

		var span = textarea.nextElementSibling.querySelector("span");
		span.textContent = count;
	}
	
	//최초 1회 실행되도록 구현 (내가 실행하는게 아니라 예약하는 것이므로 이름만 알려준다... 콜백함수)
	window.onload = calculateBoardContent;
</script>

<form action="./write.do" method="post" autocomplete="off"
		onsubmit="return checkForm();">
<!-- 만약 boardParent가 존재한다면 숨김 첨부 -->
<%if(request.getParameter("boardParent") != null) { %>
<input type="hidden" name="boardParent" value="<%=request.getParameter("boardParent")%>">
<%} %>

<div class="container w-1000 mb-50">
	<div class="cell">
		<h2>신규 게시글 작성</h2>
	</div>
	<div class="cell gray">무분별한 타인에 대한 비방글은 경고 없이 삭제될 수 있습니다</div>
	
	<hr>
	
	<div class="cell mt-40">
		<select name="boardHead" class="form-input">
			<option value="">말머리 선택</option>
			<%if(isAdmin){ %>
			<option>공지</option>
			<%} %>
			<option>자유</option>
			<option>유머</option>
			<option>정보</option>
		</select>
	</div>
	
	<div class="cell mt-40">
		<label>제목 <i class="fa-solid fa-asterisk red"></i></label>
		<input type="text" name="boardTitle" class="form-input w-100"
					onblur="checkBoardTitle();">
		<div class="fail-feedback">제목은 반드시 작성해야 합니다</div>
	</div>
	
	<div class="cell mt-40">
		<label>내용 <i class="fa-solid fa-asterisk red"></i></label>
		<textarea name="boardContent" rows="15" class="form-input w-100"
				onblur="checkBoardContent();"
				oninput="calculateBoardContent();"></textarea>
		<div class="counter right" style="font-size:20px">
			<span>?</span> / 4000 bytes
		</div>
		<div class="fail-feedback">내용은 반드시 작성해야 합니다</div>
	</div>
	
	<div class="cell mt-40">
		<button type="submit" class="form-btn positive w-100">
			<i class="fa-solid fa-floppy-disk"></i>
			<span>작성한 글 등록하기</span>
		</button>
	</div>
	
</div>

</form>

<jsp:include page="/views/template/footer.jsp"></jsp:include>





