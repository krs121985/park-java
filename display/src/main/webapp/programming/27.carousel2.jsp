<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>포켓몬 등록</title>

    <!-- google font CDN -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">

    <!-- FontAwesome CDN -->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css">

    <link rel="stylesheet" type="text/css" href="../css/commons.css">
    <style>
        
    </style>
    <!-- 홈페이지에 영향을 주는 코드를 작성하는 공간 -->
    <script type="text/javascript">
        function checkPokemonName(){
            var pokemonName = document.querySelector("[name=pokemonName]").value;
            //var feedback = document.querySelector(".feedback");//문제가 될 수 있는 코드
            //var feedback = document.querySelector("[name=pokemonName] + .feedback");//css 기법
            var input = document.querySelector("[name=pokemonName]");
            var feedback = input.nextElementSibling;//js 기법

            var regex = /^[가-힣]{2,10}$/;
            var valid = regex.test(pokemonName);//검사하세요!

            if(valid) {
                feedback.textContent = "올바른 형식의 이름입니다!";
                feedback.style.color = "blue";
            }
            else {
                feedback.textContent = "이름은 한글 2~10글자 사이로만 가능합니다";
                feedback.style.color = "red";
            }
        }
        function checkPokemonType(){
            var select = document.querySelector("[name=pokemonType]");
            var pokemonType = select.value;

            var feedback = select.nextElementSibling;//DOM 탐색(Document Object Model)
            var valid = pokemonType.length > 0;//pokemonType != "";

            if(valid) {
                feedback.textContent = "선택이 완료되었습니다";
                feedback.style.color = "blue";
            }
            else {
                feedback.textContent = "속성은 반드시 선택해야 합니다";
                feedback.style.color = "red";
            }
        }
    </script>
</head>
<body>
    <form action="#" autocomplete="off">
        <div class="container w-400">
            <div class="cell center">
                <h1>포켓몬 등록</h1>
            </div>

            <div class="cell">
                <label>몬스터명 <i class="fa-solid fa-asterisk red"></i></label>
                <input type="text" name="pokemonName" placeholder="(ex) 피카츄"
                            class="form-input w-100" onblur="checkPokemonName();">
                <div class="feedback"></div>
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
                <div class="feedback"></div>
            </div>

            <div class="cell mt-40">
                <button class="form-btn w-100 positive">
                    <i class="fa-solid fa-floppy-disk"></i>
                    <span class="ms-5">등록</span>
                </button>
            </div>
        </div>
    </form>
</body>
</html>


    