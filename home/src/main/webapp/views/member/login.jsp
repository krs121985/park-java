<%@page import="home.util.CookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	saveId라는 이름으로 생성된 쿠키가 있는지 조회하여 그에 따른 처리
// 	사용자의 쿠키 중 확인 가능한 것들을 가져오는 명령 - request.getCookies()
	
// 	Cookie[] cookies = request.getCookies();//사용자의 모든 쿠키를 가져와서
// 	String saveId = null;//처음에는 쿠키가 없다고 치고
// 	for(Cookie cookie : cookies) {//모든 쿠키를 순차적으로 조회하여
// 		if(cookie.getName().equals("saveId")) {//쿠키이름이 saveId인 것을 발견했다면
// 			saveId = cookie.getValue();//쿠키의 value를 saveId 변수에 옮겨닮고
// 			break;//그만하세요!
// 		}
// 	}

	String saveId = CookieUtil.getValue(request, "saveId"); 
%>


<jsp:include page="/views/template/header.jsp"></jsp:include>

<form action="./login.do" method="post" autocomplete="off">
	<div class="container w-400 mt-50 mb-50">
		<div class="cell center">
			<h2>로그인</h2>
		</div>
		<div class="cell">
			<label>아이디</label>
			<input type="text" name="memberId" class="form-input w-100"
					value="<%=saveId == null ? "" : saveId%>">
		</div>
		<div class="cell">
			<label>비밀번호</label>
			<input type="password" name="memberPw" class="form-input w-100">
		</div>
		
		<!-- 
			아이디 저장하기 체크박스 구현 
			- 체크박스는 value가 없으면 체크한 경우 "on"으로 전송됨
			- 체크를 안하면 아예 전송이 안됨(이름조차 없음)
		-->
		<div class="cell">
			<label>
				<input type="checkbox" name="remember" <%=saveId!=null?"checked":""%>>
				<span>아이디 기억하기</span>
			</label>
		</div>
		
		<%if(request.getParameter("error") != null) { %>
		<div class="cell red">
			입력하신 정보가 존재하지 않거나 일치하지 않습니다<br>
			다시 확인하시고 입력해주세요
		</div>
		<%} %>
		
		<div class="cell mt-40">
			<button type="submit" class="form-btn positive w-100">로그인</button>
		</div>
	</div>
</form>

<jsp:include page="/views/template/footer.jsp"></jsp:include>