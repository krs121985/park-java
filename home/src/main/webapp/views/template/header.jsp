<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//HttpSession을 조회해서 이 사용자가 로그인 상태인지 아닌지 판정하고 다른 화면을 출력
	String loginId = (String)session.getAttribute("loginId");//session의 loginId라는 값을 추출해서 저장
	String loginLevel = (String)session.getAttribute("loginLevel");//session의 loginLevel이라는 값을 추출해서 저장
	
	//로그인 상태란? loginId와 loginLevel이 모두 존재하는 것(not null)
	boolean login = loginId != null && loginLevel != null;
	boolean admin = loginLevel != null && loginLevel.equals("관리자");
%>

    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>홈페이지</title>

    <!-- google font CDN -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">

    <!-- FontAwesome CDN -->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css">

    <link rel="stylesheet" type="text/css" href="/home/resources/css/commons.css">
    <style>
        
    </style>
</head>
<body>

    <!-- 컨테이너 -->
    <div class="container w-1300">
        <!-- 헤더 -->
        <div class="cell mt-0 mb-0">
            <div class="flex-box">
                <div class="w-25 left flex-box flex-center" style="justify-content: flex-start;">
                    <img src="/home/resources/images/tjoeun_logo.png" width="200" height="50">
                </div>
                <div class="w-50 center">
                    <h1>더조은컴퓨터아카데미 종로지점</h1>
                </div>
                <div class="w-25 right">
                    <h1>
                        <i class="fa-solid fa-phone"></i>
                        <span>(02) 000-0000</span>
                    </h1>
                </div>
            </div>
        </div>
        
        <!-- 테스트 데이터 출력 화면(개발용) -->
        <div class="cell mt-0 mb-0">
        	session id = <%=session.getId()%> , 
        	loginId = <%=loginId%> , 
        	loginLevel = <%=loginLevel%>
        </div>
        
        <!-- 관리자일 경우 관리 메뉴를 추가 -->
        <%if(admin){ %>
        <div class="cell mt-0 mb-0 right" style="font-size:20px"> 
        	<a href="/home/views/admin/home.jsp">
        		<i class="fa-solid fa-gear"></i>
        		<span>홈페이지 관리</span>
        	</a>
        </div>
        <%} %>

        <!-- 메뉴 -->
        <div class="cell mt-0 mb-0">
            <div class="menu">
            	<!-- (중요) 템플릿페이지는 어디서 실행될지 모르므로 경로를 절대경로로 작성해야 한다 -->
            	<%if(login) { %>
            	<a href="/home/"><i class="fa-solid fa-house"></i>Home</a>
            	<a href="/home/views/pokemon/list.jsp"><i class="fa-brands fa-optin-monster"></i>Pokemon</a>
            	<a href="/home/views/book/list.jsp"><i class="fa-solid fa-book"></i>Book</a>
<!--                 <a href="/home/views/lecture/list.jsp"><i class="fa-solid fa-graduation-cap"></i>Lecture</a> -->
            	<a href="/home/views/board/list.jsp"><i class="fa-solid fa-list"></i>Board</a>
            	<div class="seperator"></div>
            	<a href="/home/views/member/mypage.jsp"><i class="fa-solid fa-user"></i>내정보</a>
            	<a href="/home/views/member/logoutProc.jsp"><i class="fa-solid fa-right-from-bracket"></i>로그아웃</a>
            	<%} else { %>
				<a href="/home/"><i class="fa-solid fa-house"></i>Home</a>
				<a href="/home/views/pokemon/list.jsp"><i class="fa-brands fa-optin-monster"></i>Pokemon</a>
            	<a href="/home/views/board/list.jsp"><i class="fa-solid fa-list"></i>Board</a>
            	<div class="seperator"></div>
                <a href="/home/views/member/join.jsp"><i class="fa-solid fa-user-plus"></i>회원가입</a>
                <a href="/home/views/member/login.jsp"><i class="fa-solid fa-right-to-bracket"></i>로그인</a>
            	<%} %>
            </div>
        </div>

        <!-- 사이드바와 컨텐츠 -->
        <div class="cell mt-0 mb-0">
            <div class="flex-box" style="min-height: 450px;">
                <!-- 사이드바-->
                <div style="width: 200px;">
                	<div class="container">
                		<%if(login) { %>
	            		<div class="cell center mt-50">
							<img src="/home/views/member/profile.do?memberId=<%=loginId%>" class="profile" width="150">
                		</div>
                		<div class="cell center mt-30 mb-0">
                			<%=loginId%>님
                		</div>
                		<div class="cell center mt-0">
                			(<%=loginLevel%>)
                		</div>
                		<div class="cell center mt-30">
                			<a href="/home/views/member/mypage.jsp" class="form-btn positive">
                				<i class="fa-solid fa-user"></i>
                				<span>마이페이지</span>
                			</a>
                		</div>	
		            	<%} else { %>
		            	<div class="cell mt-50">
                			<a href="/home/views/member/login.jsp">로그인</a>을 통해 다양한 기능들을 이용해보세요!
                		</div>
                		<div class="cell">
                			<a href="/home/views/member/login.jsp" class="form-btn positive">
                				<span>로그인 하러가기</span>
                				<i class="fa-solid fa-arrow-right"></i>
                			</a>
                		</div>	
		            	<%} %>
                	</div>
                
				</div>
                <!-- 컨텐츠 영역 -->
                <div class="flex-fill">
                
                
                
                
                