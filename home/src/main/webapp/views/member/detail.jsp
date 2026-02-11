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
	String memberId = request.getParameter("memberId");//남의 정보를 볼 때 사용
	
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.selectOne(memberId);
	
	//게시글 목록 조회(작성)
	BoardDao boardDao = new BoardDao();
	List<BoardDto> writeList = boardDao.selectListByBoardWriter(memberId);
%>

<jsp:include page="/views/template/header.jsp"></jsp:include>

<div class="container w-900 mt-50">
	
	<div class="cell">
		<h2><%=memberDto.getMemberId()%>님의 정보</h2>
	</div>
	
	<div class="cell">
		<img src="https://picsum.photos/500/500" width="200" class="profile">
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
			<div class="w-20 blue">최초 가입일</div>
			<div class="w-80">
<%-- 				<%=memberDto.getMemberJoinFormat()%> --%>

				<!-- 등록한 fmt 태그를 이용해서 날짜 형식을 출력 (value-날짜데이터, pattern-날짜형식) -->
				<fmt:formatDate value="<%=memberDto.getMemberJoin()%>" 
									pattern="y년 M월 d일 E a h시 m분 s초"/>
			</div>
		</div>
	</div>
	
	<hr class="mt-20 mb-20">
	<div class="cell">
		<h3>이 회원이 작성한 글</h3>
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
	
</div>


<jsp:include page="/views/template/footer.jsp"></jsp:include>








