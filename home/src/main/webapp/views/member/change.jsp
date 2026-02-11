<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//내 정보를 가져오는 코드
	String loginId = (String)session.getAttribute("loginId");
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.selectOne(loginId);
%>

<!-- 내 정보를 수정 가능하도록 화면에 표시하는 코드 -->
<jsp:include page="/views/template/header.jsp"></jsp:include>

<!-- lightpick css cdn -->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/css/lightpick.min.css">

<style>
	.show-box,
	.show-box ~ .fa-eye,
	.show-box:checked ~ .fa-eye-slash
	{
	    display: none;
	}
	.show-box ~ .fa-eye-slash,
	.show-box:checked ~ .fa-eye 
	{
	    display: inline;
	}
</style>

<!-- lightpick js cdn -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.30.1/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.30.1/locale/ko.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/lightpick.min.js"></script>

<!-- daum post api cdn -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


<script type="text/javascript">
	window.onload = app;//윈도우가 로딩되면 app을 실행하세요(콜백 함수 설정, body에 onload="app();"을 대체)
	function app() {
		//datepicker 생성 코드
		var picker = new Lightpick({
	        field : document.querySelector("[name=memberBirth]"),
	        format : "YYYY-MM-DD",
	        firstDay : 7,
	        maxDate : moment()
	        // maxDate : moment().subtract(1, 'day')
	    });
	}
	
	//닉네임 검사
	function checkMemberNickname(){
		var target = document.querySelector("[name=memberNickname]");
		var regex = /^[가-힣0-9]{2,10}$/;
		var valid = regex.test(target.value);
		target.classList.remove("success", "fail");
		target.classList.add(valid ? "success" : "fail");
		return valid;
	}	
	
	//이메일 검사
	function checkMemberEmail(){
		var target = document.querySelector("[name=memberEmail]");
		var valid = target.value.length > 0;
		target.classList.remove("success", "fail");
		target.classList.add(valid ? "success" : "fail");
		return valid;
	}
	
	//생년월일 검사
	function checkMemberBirth(){
		var target = document.querySelector("[name=memberBirth]");
		target.classList.add("success");
		return true;
	}
	
	//주소 찾기
	function findAddress() {
        //var obj = new daum.Postcode(옵션객체);
        //obj.open();
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = ''; // 주소 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.querySelector('[name=memberPost]').value = data.zonecode;
                document.querySelector("[name=memberAddress1]").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.querySelector("[name=memberAddress2]").focus();
            }
        }).open();
    }
	
	//우편번호, 기본주소, 상세주소가 "모두 미입력"이거나 "모두 입력"인 경우만 유효하다고 판정
    function checkAddress() {
        var postcode = document.querySelector("[name=memberPost]");
        var address1 = document.querySelector("[name=memberAddress1]");
        var address2 = document.querySelector("[name=memberAddress2]");

        var empty = postcode.value.length == 0 && address1.value.length == 0 && address2.value.length == 0;//모두 미입력
        var fill = postcode.value.length > 0 && address1.value.length > 0 && address2.value.length > 0;//모두 입력
        var valid = empty || fill;

        postcode.classList.remove("success", "fail");
        address1.classList.remove("success", "fail");
        address2.classList.remove("success", "fail");
        postcode.classList.add(valid ? "success" : "fail");
        address1.classList.add(valid ? "success" : "fail");
        address2.classList.add(valid ? "success" : "fail");

        return valid;
    }
	
    function checkMemberPw() {
    	var target = document.querySelector("[name=memberPw]");
    	var valid = target.value.length > 0;
    	target.classList.remove("success", "fail");
    	target.classList.add(valid ? "success" : "fail");
    	return valid;
    }
    
    function changeShowType() {
        var checkbox = document.querySelector(".show-box");
        var input = document.querySelector("[name=memberPw]");
        if(checkbox.checked) {//체크되어 있다면
            input.type = "text";
        }
        else {
            input.type = "password";
        }
    }
    
    function checkForm() {
    	var memberNicknameValid = checkMemberNickname();
    	var memberEmailValid = checkMemberEmail();
    	var memberBirthValid = checkMemberBirth();
    	var memberAddressValid = checkAddress();
    	var memberPwValid = checkMemberPw();
    	return memberNicknameValid && memberEmailValid && memberBirthValid 
    				&& memberAddressValid && memberPwValid;
    }
	
</script>


<form action="./changeProc.jsp" autocomplete="off" onsubmit="return checkForm();">

<div class="container w-800">
	<div class="cell">
		<h2>개인 정보 변경</h2>
	</div>
	
	<div class="cell">
    	<label>닉네임<i class="fa-solid fa-asterisk red"></i></label>
    	<input type="text" name="memberNickname" class="form-input w-100" 
			onblur="checkMemberNickname();" value="<%=memberDto.getMemberNickname()%>">
    	<div class="success-feedback">멋진 닉네임입니다!</div>
    	<div class="fail-feedback">닉네임은 한글 또는 숫자 2~10자로 작성하세요</div>
    </div>
    
    <div class="cell">
    	<label>이메일<i class="fa-solid fa-asterisk red"></i></label>
    	<input type="text" inputmode="email" name="memberEmail" 
    				class="form-input w-100" onblur="checkMemberEmail();"
    				value="<%=memberDto.getMemberEmail()%>">
<!--     	<div class="success-feedback"></div> -->
    	<div class="fail-feedback">이메일은 필수 항목입니다</div>
    </div>
    
    <div class="cell">
    	<label>생년월일</label>
    	<input type="text" name="memberBirth" class="form-input w-100" onblur="checkMemberBirth();" 
  			value="<%=memberDto.getMemberBirth() == null ? "" : memberDto.getMemberBirth()%>">
    </div>
    
    <div class="cell">주소</div>
    <div class="cell flex-box">
        <input type="text" inputmode="numeric" name="memberPost" class="form-input" 
            size="6" maxlength="6" placeholder="우편번호" onblur="checkAddress();"
            value="<%=memberDto.getMemberPost() == null ? "" : memberDto.getMemberPost()%>">
        <button type="button" class="form-btn positive ms-10" onclick="findAddress();">
            <i class="fa-solid fa-magnifying-glass"></i>
        </button>
    </div>
    <div class="cell">
        <input type="text" name="memberAddress1" class="form-input w-100" placeholder="기본주소" onblur="checkAddress();"
        	value="<%=memberDto.getMemberAddress1() == null ? "" : memberDto.getMemberAddress1()%>">
    </div>
    <div class="cell">
        <input type="text" name="memberAddress2" class="form-input w-100" placeholder="상세주소" onblur="checkAddress();"
        	value="<%=memberDto.getMemberAddress2() == null ? "" : memberDto.getMemberAddress2()%>">        	
        <div class="fail-feedback">주소를 모두 작성하세요</div>
    </div>
    
    <hr class="mt-40 mb-40">
    
    <!-- 비밀번호가 일치하지 않는 경우 보여줄 에러 메세지 -->
    <%if(request.getParameter("error") != null) {%>
    <div class="cell red">
		오류 : 입력하신 비밀번호가 일치하지 않습니다
    </div>
    <%} %>
    
    <div class="cell">
		<label>비밀번호 확인<i class="fa-solid fa-asterisk red"></i></label>
		
		<label class="ms-20">
            <input type="checkbox" class="show-box" oninput="changeShowType();">
            <i class="fa-solid fa-eye blue"></i>
            <i class="fa-solid fa-eye-slash red"></i>
        </label>
		
		<input type="password" name="memberPw" class="form-input w-100" onblur="checkMemberPw();">
		<div class="fail-feedback">비밀번호는 필수로 작성해야 합니다</div>
	</div>
	
	<div class="cell mt-40">
		<button type="submit" class="form-btn positive w-100">
			<i class="fa-solid fa-pen"></i>
			<span>정보 변경하기</span>
		</button>
	</div>
</div>

</form>

<jsp:include page="/views/template/footer.jsp"></jsp:include>