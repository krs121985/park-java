<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<jsp:include page="/views/template/header.jsp"></jsp:include>

<!-- 자바스크립트 -->
<!-- 홈페이지에 영향을 주는 코드를 작성하는 공간 -->
<script type="text/javascript">
    function checkPokemonName(){
        var input = document.querySelector("[name=pokemonName]");//입력창을 가져와서
        var regex = /^[가-힣]{2,10}$/;//검사식을 만들고
        var valid = regex.test(input.value);//검사를 한 다음

        input.classList.remove("success", "fail");//입력창에 붙어있는 success와 fail 클래스 모두 제거
        input.classList.add(valid ? "success" : "fail");
        return valid;//검사 결과를 반환하세요!
    }
    function checkPokemonType(){
        var select = document.querySelector("[name=pokemonType]");
        var pokemonType = select.value;
        var valid = pokemonType.length > 0;//pokemonType != "";
        select.classList.remove("success", "fail");//기존 클래스 제거
        select.classList.add(valid ? "success" : "fail");//3항 연산자 (if~else 축소판)
        return valid;//검사 결과를 반환하세요!
    }

    //여기서 모든 항목에 대한 검사를 또 하자니... 효율이 안좋아 보인다
    //어떻게 하면 저 위에 있는 함수를 이용할 수 있을까?
    function checkForm() {
        var pokemonNameValid = checkPokemonName();
        var pokemonTypeValid = checkPokemonType();
        return pokemonNameValid && pokemonTypeValid;
    }
</script>

<!-- 화면 -->
<form action="./add.do" method="post" enctype="multipart/form-data" autocomplete="off" onsubmit="return checkForm();">
	<div class="container w-400">
	    <div class="cell center">
	        <h1>포켓몬 등록</h1>
	    </div>
	
	    <div class="cell">
	        <label>몬스터명 <i class="fa-solid fa-asterisk red"></i></label>
	        <input type="text" name="pokemonName" placeholder="(ex) 피카츄"
	                    class="form-input w-100" onblur="checkPokemonName();">
            <div class="success-feedback">올바른 형식의 이름입니다!</div>
            <div class="fail-feedback">이름은 한글 2~10글자로 설정해야 합니다</div>
        </div>

        <div class="cell">
            <label>몬스터 속성 <i class="fa-solid fa-asterisk red"></i></label>
            <select name="pokemonType" class="form-input w-100" oninput="checkPokemonType();">
                <option value="">선택하세요</option>
                <option>땅</option>
                <option>불</option>
                <option>바람</option>
                <option>물</option>
                <option>풀</option>
                <option>독</option>
                <option>비행</option>
                <option>얼음</option>
                <option>곤충</option>
                <option>무속성</option>
            </select>
            <div class="success-feedback">속성 선택이 완료되었습니다</div>
            <div class="fail-feedback">이 항목은 반드시 선택해야 합니다</div>
        </div>
        
        <!-- (추가) 파일 업로드 창을 추가 구현 -->
        <div class="cell">
        	<label>몬스터 이미지</label>
        	<input type="file" name="attach" class="form-input w-100" accept=".png, .jpg">
        </div>

        <div class="cell mt-40">
            <button class="form-btn w-100 positive">
                <i class="fa-solid fa-floppy-disk"></i>
                <span class="ms-5">등록</span>
            </button>
        </div>
    </div>
</form>

<jsp:include page="/views/template/footer.jsp"></jsp:include>