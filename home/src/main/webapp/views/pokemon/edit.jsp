<%@page import="home.beans.PokemonDto"%>
<%@page import="home.beans.PokemonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//등록화면에 정보를 같이 표시해서 수정화면으로 전달할 수 있도록 개조
	int pokemonNo = Integer.parseInt(request.getParameter("pokemonNo"));//번호를 받아서
	PokemonDao pokemonDao = new PokemonDao();//pokemon 테이블 조회도구를 만들고
	PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);//포켓몬 정보를 조회한다 (상세페이지와 동일)
%>
j
    
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
<form action="./edit.do" method="post" autocomplete="off" onsubmit="return checkForm();">
	<!-- (중요) 반드시 번호를 숨김 첨부해야함 -->
	<input type="hidden" name="pokemonNo" value="<%=pokemonDto.getPokemonNo()%>">

	<div class="container w-400">
	    <div class="cell center">
	        <h1>포켓몬 정보 수정</h1>
	    </div>
	
	    <div class="cell">
	        <label>몬스터명 <i class="fa-solid fa-asterisk red"></i></label>
	        <!-- (중요) 입력창에 원래의 값을 출력해야 사용자가 이걸 보고 수정할지 말지 결정한다 -->
	        <input type="text" name="pokemonName" placeholder="(ex) 피카츄"
	                    class="form-input w-100" onblur="checkPokemonName();"
	                    value="<%=pokemonDto.getPokemonName()%>">
            <div class="success-feedback">올바른 형식의 이름입니다!</div>
            <div class="fail-feedback">이름은 한글 2~10글자로 설정해야 합니다</div>
        </div>

        <div class="cell">
            <label>몬스터 속성 <i class="fa-solid fa-asterisk red"></i></label>
            <!-- (중요) 입력창에 원래의 값을 출력해야 사용자가 이걸 보고 수정할지 말지 결정한다 -->
            <select name="pokemonType" class="form-input w-100" oninput="checkPokemonType();">
                <option value="">선택하세요</option>
                <option <%=pokemonDto.getPokemonType().equals("땅") ? "selected" : ""%>>땅</option>
                <option <%=pokemonDto.getPokemonType().equals("불") ? "selected" : ""%>>불</option>
                <option <%=pokemonDto.getPokemonType().equals("바람") ? "selected" : ""%>>바람</option>
                <option <%=pokemonDto.getPokemonType().equals("물") ? "selected" : ""%>>물</option>
                <option <%=pokemonDto.getPokemonType().equals("풀") ? "selected" : ""%>>풀</option>
                <option <%=pokemonDto.getPokemonType().equals("독") ? "selected" : ""%>>독</option>
                <option <%=pokemonDto.getPokemonType().equals("비행") ? "selected" : ""%>>비행</option>
                <option <%=pokemonDto.getPokemonType().equals("얼음") ? "selected" : ""%>>얼음</option>
                <option <%=pokemonDto.getPokemonType().equals("곤충") ? "selected" : ""%>>곤충</option>
                <option <%=pokemonDto.getPokemonType().equals("무속성") ? "selected" : ""%>>무속성</option>
            </select>
            <div class="success-feedback">속성 선택이 완료되었습니다</div>
            <div class="fail-feedback">이 항목은 반드시 선택해야 합니다</div>
        </div>

        <div class="cell mt-40 right">
        	<a href="./detail.jsp?pokemonNo=<%=pokemonNo%>" class="form-btn negative">
        		<i class="fa-solid fa-xmark"></i>
        		<span class="ms-5">돌아가기</span>
        	</a>
        	
            <button class="form-btn positive">
                <i class="fa-solid fa-pen"></i>
                <span class="ms-5">수정하기</span>
            </button>
        </div>
    </div>
</form>

<jsp:include page="/views/template/footer.jsp"></jsp:include>