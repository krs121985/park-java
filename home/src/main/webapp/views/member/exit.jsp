<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<jsp:include page="/views/template/header.jsp"></jsp:include>

<script type="text/javascript">
function checkMemberPw() {
	var target = document.querySelector("[name=memberPw]");
	var valid = target.value.length > 0;
	target.classList.remove("success", "fail");
	target.classList.add(valid ? "success" : "fail");
	return valid;
}
function checkForm() {
	var memberPwValid = checkMemberPw();
	return memberPwValid;
}
</script>

<form action="./exitProc.jsp" autocomplete="off" onsubmit="return checkForm();">

<div class="container w-500">
	
	<div class="cell center">
		<h2>회원 탈퇴</h2>
	</div>
	<div class="cell center">
		탈퇴를 위해 <span class="red">비밀번호</span>를 한 번 더 입력해주세요
	</div>
	
	<div class="cell mt-40">
		<label>비밀번호<i class="fa-solid fa-asterisk red"></i></label>
		<input type="password" name="memberPw" class="form-input w-100" onblur="checkMemberPw();">
		<div class="fail-feedback">필수 작성 항목입니다</div>
	</div>
	
	<!-- (추가) 에러 시 보여줄 메세지 -->
	<%if(request.getParameter("error") != null) { %>
	<div class="cell red">
		비밀번호가 일치하지 않습니다. 
		다시 확인 후 입력해주세요.
	</div>
	<%} %>
	
	<div class="cell mt-40">
		<button type="submit" class="form-btn w-100 negative">
			<i class="fa-solid fa-user-xmark"></i>
			<span>회원 탈퇴하겠습니다</span>
		</button>
	</div>
	
</div>

</form>


<jsp:include page="/views/template/footer.jsp"></jsp:include>