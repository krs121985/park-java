<%@page import="home.beans.BoardDto"%>
<%@page import="home.beans.BoardDao"%>
<%@page import="home.beans.HistoryDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.HistoryDao"%>
<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 기본 제공되는 도구 외에 추가 기능을 사용할 수 있도록 등록 (신규 태그를 추가) -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	//작성하면 안되는 코드
	//String memberId = request.getParameter("memberId");//남의 정보를 볼 때 사용
	
	//작성해야 하는 코드
	String loginId = (String)session.getAttribute("loginId");//세션에 저장된 내 아이디를 가져온다
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.selectOne(loginId);
	
	//로그인 이력 조회
	HistoryDao historyDao = new HistoryDao();
	List<HistoryDto> historyList = historyDao.selectList(loginId); 
	
	//게시글 목록 조회(작성or시청)
	BoardDao boardDao = new BoardDao();
	List<BoardDto> writeList = boardDao.selectListByBoardWriter(loginId);
	List<BoardDto> activityList = boardDao.selectActivity(loginId);	
%>

<jsp:include page="/views/template/header.jsp"></jsp:include>

<div class="container w-900 mt-50">
	
	<div class="cell">
		<h2><%=memberDto.getMemberId()%>님의 정보</h2>
	</div>
	
	<div class="cell">
		<img src="./profile.do?memberId=<%=memberDto.getMemberId()%>" width="200" class="profile">
	</div>
	
	<div class="cell mt-40">
		<div class="flex-box">
			<div class="w-20 blue">닉네임</div>
			<div class="w-80"><%=memberDto.getMemberNickname()%></div>
		</div>
	</div>
	<div class="cell mt-20">
		<div class="flex-box">
			<div class="w-20 blue">생년월일</div>
			<div class="w-80">
<%-- 				<%=memberDto.getMemberBirth() == null ? "설정하지 않음" : memberDto.getMemberBirth()%> --%>
				<%if(memberDto.getMemberBirth() == null) { %>
					<span class="gray">설정하지 않음</span>
				<%} else { %>
					<%=memberDto.getMemberBirth()%>
				<%} %>
			</div>
		</div>
	</div>
	<div class="cell mt-20">
		<div class="flex-box">
			<div class="w-20 blue">주소</div>
			<div class="w-80">
				<%if(memberDto.getMemberPost() == null) { %>
					<span class="gray">설정하지 않음</span>
				<%} else { %>
					[<%=memberDto.getMemberPost()%>] 
					<%=memberDto.getMemberAddress1()%>  
					<%=memberDto.getMemberAddress2()%>
				<%} %>
			</div>
		</div>
	</div>
	<div class="cell mt-20">
		<div class="flex-box">
			<div class="w-20 blue">최초 가입일</div>
			<div class="w-80">
<%-- 				<%=memberDto.getMemberJoinFormat()%> --%>

				<!-- 등록한 fmt 태그를 이용해서 날짜 형식을 출력 (value-날짜데이터, pattern-날짜형식) -->
				<fmt:formatDate value="<%=memberDto.getMemberJoin()%>" 
									pattern="y년 M월 d일 E a h시 m분 s초"/>
			</div>
		</div>
	</div>
	<div class="cell mt-20">
		<div class="flex-box">
			<div class="w-20 blue">최종 로그인</div>
			<div class="w-80">
<%-- 				<%=memberDto.getMemberLoginFormat()%> --%>
				<fmt:formatDate value="<%=memberDto.getMemberLogin()%>" pattern="y년 M월 d일 E a h시 m분 s초"/>
			</div>
		</div>
	</div>
	<div class="cell mt-20">
		<div class="flex-box">
			<div class="w-20 blue">최종 비밀번호 설정일</div>
			<div class="w-80">
				<%if(memberDto.getMemberChange() == null) { %>
					<span class="gray">설정하지 않음</span>
				<%} else { %>
<%-- 					<%=memberDto.getMemberChangeFormat()%>  --%>
					<fmt:formatDate value="<%=memberDto.getMemberChange()%>" pattern="y년 M월 d일 E a h시 m분 s초"></fmt:formatDate>
				<%} %>
			</div>
		</div>
	</div>
	
	<hr class="mt-20 mb-20">
	<!-- 내가 작성한 글 목록 -->
	<div class="cell">
		<h3>내가 작성한 글</h3>
	</div>
	<div class="cell">
		<div class="flex-box mb-10 blue">
			<div class="w-20">번호</div>
			<div class="w-50">제목</div>
			<div class="flex-fill">작성자</div>
		</div>
		<%for(BoardDto boardDto : writeList) { %>
		<div class="flex-box">
			<div class="w-20"><%=boardDto.getBoardNo()%></div>
			<div class="w-50">
				<a href="/home/views/board/detail.jsp?boardNo=<%=boardDto.getBoardNo()%>">
					<%=boardDto.getBoardTitle()%>
				</a>
			</div>
			<div class="flex-fill"><%=boardDto.getBoardWriter()%></div>
		</div>
		<%} %>
	</div>
	
	<hr class="mt-20 mb-20">	
	<!-- 내가 읽은 글 목록 -->
	<div class="cell">
		<h3>내가 읽은 글</h3>
	</div>
	
	<div class="cell">
		<div class="flex-box mb-10 blue">
			<div class="w-20">번호</div>
			<div class="w-50">제목</div>
			<div class="flex-fill">작성자</div>
		</div>
		<%for(BoardDto boardDto : activityList) { %>
		<div class="flex-box">
			<div class="w-20"><%=boardDto.getBoardNo()%></div>
			<div class="w-50">
				<a href="/home/views/board/detail.jsp?boardNo=<%=boardDto.getBoardNo()%>">
					<%=boardDto.getBoardTitle()%>
				</a>
			</div>
			<div class="flex-fill"><%=boardDto.getBoardWriter()%></div>
		</div>
		<%} %>
	</div>
	
	
	<hr class="mt-20 mb-20">
	
	<div class="cell">
		<h3>로그인 이력</h3>
	</div>
	<div class="cell">
		<div class="flex-box blue mb-30"> 
			<div class="w-25">시간</div>
			<div class="w-25">호스트</div>
			<div class="w-50">기기정보</div>
		</div>
		<%for(HistoryDto historyDto : historyList) { %>
		<div class="flex-box">
			<div class="w-25">
				<fmt:formatDate value="<%=historyDto.getHistoryTime()%>"
								pattern="yyyy-MM-dd HH:mm:ss"/>
			</div>
			<div class="w-25"><%=historyDto.getHistoryOrigin()%></div>
			<div class="w-50"><%=historyDto.getHistoryAgent()%></div>
		</div>
		<%} %>
	</div>
	
	<hr class="mt-20 mb-20">
	
	<div class="cell">
		<a href="./password.jsp" class="form-btn neutral">
			<i class="fa-solid fa-lock"></i>
			<span>비밀번호 변경</span>
		</a>
		<a href="./change.jsp" class="form-btn neutral">
			<i class="fa-solid fa-circle-info"></i>
			<span>개인정보 변경</span>
		</a>
		<a href="./exit.jsp" class="form-btn negative">
			<i class="fa-solid fa-user-xmark"></i>
			<span>회원 탈퇴</span>
		</a>
	</div>
	
</div>


<jsp:include page="/views/template/footer.jsp"></jsp:include>








