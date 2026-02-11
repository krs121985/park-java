<%@page import="home.beans.BookDto"%>
<%@page import="home.beans.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//기존 정보를 표시하기 위하여 데이터를 불러오는 코드
	int bookNo = Integer.parseInt(request.getParameter("bookNo"));
	BookDao bookDao = new BookDao();
	BookDto bookDto = bookDao.selectOne(bookNo);
%>


<jsp:include page="/views/template/header.jsp"></jsp:include>
    
<!-- 홈페이지에 영향을 주는 코드를 작성하는 공간 -->
<script type="text/javascript">
   function checkBookTitle() {
       var target = document.querySelector("[name=bookTitle]");
       var valid = target.value.length > 0;
       target.classList.remove("success", "fail");
       target.classList.add(valid ? "success" : "fail");
       return valid;
   }
   function checkBookGenre() {
       var target = document.querySelector("[name=bookGenre]");
       var valid = target.value.length > 0;
       target.classList.remove("success", "fail");
       target.classList.add(valid ? "success" : "fail");
       return valid;
   }
   //(+추가) 애초에 숫자만 입력되도록 처리
   function filterBookPageCount() {
       var target = document.querySelector("[name=bookPageCount]");
       var regex = /[^0-9]+/;//숫자가 아닌 글자에 대한 패턴
       var convert = target.value.replace(regex, "");//regex에 해당하는 패턴을 다 지워!
       target.value = convert;//값 덮어쓰기
   }
   function checkBookPageCount() {
       var target = document.querySelector("[name=bookPageCount]");
       var value = parseInt(target.value);//숫자로 변경
       var valid = value > 0;//0보다 크면 유효한걸로 판정
       target.classList.remove("success", "fail");
       target.classList.add(valid ? "success" : "fail");       
       return valid;     
   }
   function filterBookPrice() {
       var target = document.querySelector("[name=bookPrice]");
       var regex = /[^0-9]+/;
       var convert = target.value.replace(regex, "");
       //target.value = convert;
       //target.value = convert.length == 0 ? 0 : parseInt(convert);
       target.value = convert.length == 0 ? "" : parseInt(convert);
   }
   function checkBookPrice() {
       var target = document.querySelector("[name=bookPrice]");
       var value = parseInt(target.value);//숫자로 변경
       var valid = value >= 0;//0 이상이면 유효한걸로 재판정//2차 판정
       target.classList.remove("success", "fail");
       target.classList.add(valid ? "success" : "fail");
       return valid;
   }
   //function checkBookStatus() {}

   function checkForm() {
       var bookTitleValid = checkBookTitle();
       var bookGenreValid = checkBookGenre();
       var bookPageCountValid = checkBookPageCount();
       var bookPriceValid = checkBookPrice();
       return bookTitleValid && bookGenreValid && bookPageCountValid && bookPriceValid;
   }
</script>

<!-- 전송주소를 수정 처리페이지로 변경 -->
<form action="./edit.do" method="post" autocomplete="off" onsubmit="return checkForm();">
	<!-- 기본키를 숨김 처리하여 전송 -->
	<input type="hidden" name="bookNo" value="<%=bookDto.getBookNo()%>">

   	<div class="container w-400">
       
       <div class="cell center">
           <h1>도서 정보 입력</h1>
       </div>

       <div class="cell">
           <label>도서명 <i class="fa-solid fa-asterisk red"></i></label>
           <!-- 기존 값을 표시하거나 선택해두도록 처리 -->
           <input type="text" name="bookTitle" class="form-input w-100" 
           			onblur="checkBookTitle();" value="<%=bookDto.getBookTitle()%>">
           <div class="success-feedback">도서명이 올바르게 입력되었습니다</div>
           <div class="fail-feedback">이 항목은 필수 항목입니다</div>
       </div>

       <div class="cell">
           <label>장르 <i class="fa-solid fa-asterisk red"></i></label>
           <!-- 기존 값을 표시하거나 선택해두도록 처리 -->
           <select name="bookGenre" class="form-input w-100" oninput="checkBookGenre();">
               <option value="">선택하세요</option>
               <option <%=bookDto.getBookGenre().equals("기술")?"selected":""%>>기술</option>
               <option <%=bookDto.getBookGenre().equals("소설")?"selected":""%>>소설</option>
               <option <%=bookDto.getBookGenre().equals("교양")?"selected":""%>>교양</option>
               <option <%=bookDto.getBookGenre().equals("시사")?"selected":""%>>시사</option>
               <option <%=bookDto.getBookGenre().equals("동화")?"selected":""%>>동화</option>
               <option <%=bookDto.getBookGenre().equals("미스터리")?"selected":""%>>미스터리</option>
               <option <%=bookDto.getBookGenre().equals("경제")?"selected":""%>>경제</option>
               <option <%=bookDto.getBookGenre().equals("정치")?"selected":""%>>정치</option>
           </select>
           <div class="success-feedback">장르 선택이 완료되었습니다</div>
           <div class="fail-feedback">이 항목은 반드시 선택해야 합니다</div>
       </div>

       <div class="cell">
           <label>페이지 수 <i class="fa-solid fa-asterisk red"></i></label>
           <!-- 기존 값을 표시하거나 선택해두도록 처리 -->
           <input type="text" inputmode="numeric" name="bookPagecount" class="form-input w-100" 
                   onblur="checkBookPageCount();" oninput="filterBookPageCount();"
                   value="<%=bookDto.getBookPagecount()%>">   
           <div class="success-feedback">페이지 수 설정이 완료되었습니다</div>
           <div class="fail-feedback">1 이상의 숫자로만 설정이 가능합니다</div>
       </div>

       <div class="cell">
           <label>판매가 <i class="fa-solid fa-asterisk red"></i></label>
           <!-- 기존 값을 표시하거나 선택해두도록 처리 -->
           <input type="text" inputmode="numeric" name="bookPrice" class="form-input w-100"
                       onblur="checkBookPrice();" oninput="filterBookPrice();"
                       value="<%=bookDto.getBookPrice()%>">
           <div class="success-feedback">가격 설정이 완료되었습니다</div>
           <div class="fail-feedback">가격은 0 이상으로만 설정이 가능합니다</div>
       </div>

       <div class="cell">
           <label>상태 <i class="fa-solid fa-asterisk red"></i></label>
           <!-- 기존 값을 표시하거나 선택해두도록 처리 -->
           <select name="bookStatus" class="form-input w-100">
               <option <%=bookDto.getBookStatus().equals("대여가능")?"selected":""%>>대여가능</option>
               <option <%=bookDto.getBookStatus().equals("대여중")?"selected":""%>>대여중</option>
               <option <%=bookDto.getBookStatus().equals("대여불가")?"selected":""%>>대여불가</option>
           </select>
       </div>

        <div class="cell mt-40 right">
            <a href="./detail.jsp?bookNo=<%=bookNo%>" class="form-btn negative">
            	<i class="fa-solid fa-xmark"></i>
            	<span>돌아가기</span>
            </a>
            <button type="submit" class="form-btn">
            	<i class="fa-solid fa-pen"></i>
            	<span>수정하기</span>
            </button>
        </div>
        
    </div>
    
</form>

 
<jsp:include page="/views/template/footer.jsp"></jsp:include>