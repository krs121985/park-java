<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/views/template/header.jsp"></jsp:include>

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
	
	.progressbar {
	    height: 10px;
	    /* border: 1px solid black; */
	    box-shadow: 0 0 1px 0 #2d3436;
	}
	.guage {
	    background-color: yellow;
	    width: 0%;
	    height: 100%;
	}
</style>
<script type="text/javascript">
function checkMemberPw() {
	var target = document.querySelector("[name=memberPw]");
	var valid = target.value.length > 0;
	target.classList.remove("success", "fail");
	target.classList.add(valid ? "success" : "fail");
	return valid;
}
function checkChangePw() {
	var input = document.querySelector("[name=changePw]");
    var memberPw = input.value;

    //[1]번 조건 : 글자수 8~16자
    //var condition1 = memberPw.length >= 8 && memberPw.length <= 16;
    var condition1 = /^[A-Za-z0-9!@#$]{8,16}$/.test(memberPw);
    var feedback1 = document.querySelector(".password-feedback1");
    feedback1.classList.remove("red", "blue");
    feedback1.classList.add(condition1 ?  "blue" : "red");

    //[2]번 조건 : 대문자 하나 이상 포함
    //var condition2 = memberPw != memberPw.toLowerCase();
    var condition2 = /[A-Z]+/.test(memberPw);
    var feedback2 = document.querySelector(".password-feedback2");
    feedback2.classList.remove("red", "blue");
    feedback2.classList.add(condition2 ?  "blue" : "red");

    //[3]번 조건 : 소문자 하나 이상 포함
    var condition3 = /[a-z]+/.test(memberPw);
    var feedback3 = document.querySelector(".password-feedback3");
    feedback3.classList.remove("red", "blue");
    feedback3.classList.add(condition3 ?  "blue" : "red");

    //[4]번 조건 : 숫자 하나 이상 포함
    var condition4 = /[0-9]+/.test(memberPw);
    var feedback4 = document.querySelector(".password-feedback4");
    feedback4.classList.remove("red", "blue");
    feedback4.classList.add(condition4 ?  "blue" : "red");

    //[5]번 조건 : 특수문자 하나 이상 포함
    var condition5 = /[!@#$]+/.test(memberPw);
    var feedback5 = document.querySelector(".password-feedback5");
    feedback5.classList.remove("red", "blue");
    feedback5.classList.add(condition5 ?  "blue" : "red");

    //최종 통과 판정
    var valid = condition1 && condition2 && condition3 && condition4 && condition5;
    input.classList.remove("success", "fail");
    input.classList.add(valid ? "success" : "fail");

    //(+심화) 통과된 개수를 세어서 게이지 표시 (진행률)
    var count = 0;
    if(condition1) count++;
    if(condition2) count++;
    if(condition3) count++;
    if(condition4) count++;
    if(condition5) count++;

    var color;
    switch(count) {
        case 1: color = "#d63031"; break;
        case 2: color = "#e17055"; break;
        case 3: color = "#fdcb6e"; break;
        case 4: color = "#00b894"; break;
        case 5: color = "#0984e3"; break;
        default: color = ""; break;
    }

    var percent = count * 100 / 5;
    var guage = document.querySelector(".guage");
    guage.style.width = percent +"%";
    guage.style.backgroundColor = color;	

    //비밀번호 확인과 일치하는지 검사
    var target2 = document.querySelector(".password-checker");

    //var valid = 비밀번호가 입력되어 있고 비밀번호와 확인값이 같아야 함;
    var valid2 = input.value.length > 0 && input.value == target2.value;

    target2.classList.remove("success", "fail");
    target2.classList.add(valid2 ? "success" : "fail");
    
    return valid && valid2;
}
function changeShowType() {
    var checkbox = document.querySelector(".show-box");
    var input = document.querySelector("[name=memberPw]");
    var input2 = document.querySelector("[name=changePw]");
    var input3 = document.querySelector(".password-checker");
    if(checkbox.checked) {//체크되어 있다면
        input.type = "text";
    	input2.type = "text";
    	input3.type = "text";
    }
    else {
        input.type = "password";
        input2.type = "password";
        input3.type = "password";
    }
}
function checkForm() {
	var memberPwValid = checkMemberPw();
	var changePwValid = checkChangePw();
	return memberPwValid && changePwValid;
}
</script>


<form action="passwordProc.jsp" autocomplete="off" onsubmit="return checkForm();">

<div class="container w-500">

	<div class="cell center">
		<h2>비밀번호 변경</h2>
	</div>
	
	<!-- (+추가) ?error 가 존재하는 경우 메세지 표시 추가 -->
	<%if(request.getParameter("error") != null) { %>
	<div class="cell center red" style="font-size: 20px;">
		오류 : 기존 비밀번호가 일치하지 않습니다
	</div>
	<%} %>
	
	<div class="cell">
		<label>기존 비밀번호<i class="fa-solid fa-asterisk red"></i></label>
		<input type="password" name="memberPw" class="form-input w-100" onblur="checkMemberPw();">
		<div class="fail-feedback">기존 비밀번호는 필수로 작성해야 합니다</div>
	</div>
	
    <div class="cell">
        <label>신규 비밀번호<i class="fa-solid fa-asterisk red"></i></label>
        
        <label class="ms-20">
            <input type="checkbox" class="show-box" oninput="changeShowType();">
            <i class="fa-solid fa-eye blue"></i>
            <i class="fa-solid fa-eye-slash red"></i>
        </label>
        
        <input type="password" name="changePw" class="form-input w-100" 
        		onblur="checkChangePw();" oninput="checkChangePw();">

        <!-- 보안수준을 표시하기 위한 영역 -->
        <div class="progressbar">
            <div class="guage"></div>
        </div>

        <div class="password-feedback1">비밀번호는 대소문자, 숫자, 특수문자 8~16자로 작성해야 합니다</div>
        <div class="password-feedback2">비밀번호에는 반드시 한 개 이상의 대문자가 포함되어야 합니다</div>
        <div class="password-feedback3">비밀번호에는 반드시 한 개 이상의 소문자가 포함되어야 합니다</div>
        <div class="password-feedback4">비밀번호에는 반드시 한 개 이상의 숫자가 포함되어야 합니다</div>
        <div class="password-feedback5">비밀번호에는 반드시 한 개 이상의 특수문자(!, @, #< $)가 포함되어야 합니다</div>
    </div>

    <div class="cell">
        <label>비밀번호 확인<i class="fa-solid fa-asterisk red"></i></label>
        <input type="password" class="form-input w-100 password-checker" onblur="checkChangePw();">
        <div class="success-feedback">비밀번호가 일치합니다</div>
        <div class="fail-feedback">비밀번호가 없거나 일치하지 않습니다</div>
    </div>
    
    <div class="cell mt-40">
    	<button type="submit" class="form-btn positive w-100">
    		<i class="fa-solid fa-lock"></i>
    		<span>비밀번호 변경하기</span>
    	</button>
    </div>
	
</div>

</form>


<jsp:include page="/views/template/footer.jsp"></jsp:include>