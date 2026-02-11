<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

	function changeShowType() {
	    var checkbox = document.querySelector(".show-box");
	    var input = document.querySelector("[name=memberPw]");
	    var input2 = document.querySelector(".password-checker");
	    if(checkbox.checked) {//체크되어 있다면
	        input.type = "text";
	    	input2.type = "text";
	    }
	    else {
	        input.type = "password";
	        input2.type = "password";
	    }
	}

	function checkMemberId() {
	    var target = document.querySelector("[name=memberId]");
	    var regex = /^[a-z][a-z0-9]{4,19}$/;
	    var valid = regex.test(target.value);
	    target.classList.remove("success", "fail");
	    target.classList.add(valid ? "success" : "fail");
	    return valid;
	}
	function checkMemberPw() {
		var input = document.querySelector("[name=memberPw]");
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
	
	function checkForm() {
	    var memberIdValid = checkMemberId();
	    var memberPwValid = checkMemberPw();
	    var memberNicknameValid = checkMemberNickname();
	    var memberEmailValid = checkMemberEmail();
	    var memberBirthValid = checkMemberBirth();
	    var memberAddressValid = checkAddress();
	    return memberIdValid && memberPwValid 
	    		&& memberNicknameValid && memberEmailValid 
	    		&& memberBirthValid && memberAddressValid;
	}
</script>


<form action="./join.do" method="post" enctype="multipart/form-data" autocomplete="off" onsubmit="return checkForm();">

<div class="container w-600">
    <div class="cell center">
        <h1>회원 가입</h1>
    </div>

    <div class="cell">
        <label>아이디<i class="fa-solid fa-asterisk red"></i></label>
        <input type="text" name="memberId" class="form-input w-100" onblur="checkMemberId();">
        <div class="success-feedback">멋진 아이디네요!</div>
        <div class="fail-feedback">영문 소문자로 시작하며 소문자와 숫자를 합쳐 5~20자로 작성하세요</div>
    </div>

    <div class="cell">
        <label>비밀번호<i class="fa-solid fa-asterisk red"></i></label>
        
        <label class="ms-20">
            <input type="checkbox" class="show-box" oninput="changeShowType();">
            <i class="fa-solid fa-eye blue"></i>
            <i class="fa-solid fa-eye-slash red"></i>
        </label>
        
        <input type="password" name="memberPw" class="form-input w-100" 
        		onblur="checkMemberPw();" oninput="checkMemberPw();">

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
        <input type="password" class="form-input w-100 password-checker" onblur="checkMemberPw();">
        <div class="success-feedback">비밀번호가 일치합니다</div>
        <div class="fail-feedback">비밀번호가 없거나 일치하지 않습니다</div>
    </div>
    
    <div class="cell">
    	<label>닉네임<i class="fa-solid fa-asterisk red"></i></label>
    	<input type="text" name="memberNickname" class="form-input w-100" 
    				onblur="checkMemberNickname();">
    	<div class="success-feedback">멋진 닉네임입니다!</div>
    	<div class="fail-feedback">닉네임은 한글 또는 숫자 2~10자로 작성하세요</div>
    </div>
    
    <div class="cell">
    	<label>이메일<i class="fa-solid fa-asterisk red"></i></label>
    	<input type="text" inputmode="email" name="memberEmail" 
    				class="form-input w-100" onblur="checkMemberEmail();">
<!--     	<div class="success-feedback"></div> -->
    	<div class="fail-feedback">이메일은 필수 항목입니다</div>
    </div>
    
    <div class="cell">
    	<label>생년월일</label>
    	<input type="text" name="memberBirth" class="form-input w-100" 
    				onblur="checkMemberBirth();">
    </div>
    
    <div class="cell">주소</div>
    <div class="cell flex-box">
        <input type="text" inputmode="numeric" name="memberPost" class="form-input" 
            size="6" maxlength="6" placeholder="우편번호" onblur="checkAddress();">
        <button type="button" class="form-btn positive ms-10" onclick="findAddress();">
            <i class="fa-solid fa-magnifying-glass"></i>
        </button>
    </div>
    <div class="cell">
        <input type="text" name="memberAddress1" class="form-input w-100" placeholder="기본주소" onblur="checkAddress();">
    </div>
    <div class="cell">
        <input type="text" name="memberAddress2" class="form-input w-100" placeholder="상세주소" onblur="checkAddress();">
        <div class="fail-feedback">주소를 모두 작성하세요</div>
    </div>
    
    <!-- (추가) 프로필 이미지 선택 화면 -->
    <div class="cell">
    	<label>프로필 이미지</label>
    	<input type="file" name="attach" class="form-input w-100" accept=".png, .jpg">
    </div>
    
    <div class="cell mt-40">
        <button type="submit" class="form-btn positive w-100">
            <i class="fa-solid fa-user-plus"></i>
            <span>회원 가입</span>
        </button>
    </div>
    
</div>


</form>

<jsp:include page="/views/template/footer.jsp"></jsp:include>