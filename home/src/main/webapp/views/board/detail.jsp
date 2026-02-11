<%@page import="home.beans.MemberDao"%>
<%@page import="home.beans.BoardDto"%>
<%@page import="home.beans.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL (Jsp Standard Tag Library의 줄임말) --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	String loginId = (String)session.getAttribute("loginId");//null 가능(비회원)
	String loginLevel = (String)session.getAttribute("loginLevel");//null 가능(비회원)
	
	int boardNo = Integer.parseInt(request.getParameter("boardNo")); 
	BoardDao boardDao = new BoardDao();
	
	//조회수 증가 후 게시글 정보를 불러와야 한다 (그래야 화면에 증가된 조회수가 나옴)
	//boardDao.updateBoardRead(boardNo, loginId);//1번만 처리한 경우(작성자본인 제거)
	
	//시청기록 추가 (회원일 경우)
	if(loginId != null) {
		MemberDao memberDao = new MemberDao();
		if(memberDao.checkActivity(loginId, boardNo)) {
		 	memberDao.updateActivity(loginId, boardNo);
		}
		else {
			memberDao.insertActivity(loginId, boardNo);
			boardDao.updateBoardRead(boardNo, loginId);//4번까지 처리한 경우(무조건 최초시청만 조회수 증가)
		}
	}
	
	BoardDto boardDto = boardDao.selectOne(boardNo); 
	
	//여러 상태들을 미리 계산
	boolean isWriter = loginId != null && loginId.equals(boardDto.getBoardWriter());
	boolean isAdmin = loginLevel != null && loginLevel.equals("관리자");
	boolean isMember = loginId != null && loginLevel != null;
%>    

<jsp:include page="/views/template/header.jsp"></jsp:include>

<style>
	/* textarea에서 작성한 내용을 HTML에 동일하게 표시할 수 있도록 처리하는 방법 */
	pre.content-viewer {
		white-space: pre-wrap;
		word-break: break-all;
	}
</style>

<script type="text/javascript">
	function checkMove() {
		var choice = window.confirm("정말 삭제하시겠습니까?");
		return choice;
	}
</script>

<div class="container w-1000">
	<div class="cell"><%=boardDto.getBoardNo()%>번 게시글</div> 
	<div class="cell">
		<h2>
			<!-- 말머리 표시 -->
			<%if(boardDto.getBoardHead() != null) { %>
				<%if(boardDto.getBoardHead().equals("공지")){ %>
					<span class="red">
						<i class="fa-solid fa-circle-exclamation fa-fade"></i>
					</span>
				<%} else { %>
					<span class="gray">[ <%=boardDto.getBoardHead()%> ]</span>
				<%} %>
			<%} %>
		
			<!-- 게시글 제목 -->
			<%=boardDto.getBoardTitle()%>
			
			<!-- 수정됨 표시 -->
			<%if(boardDto.getBoardEtime() != null){ %>
			<span class="red">(수정됨)</span>
			<%} %>
		</h2>
	</div>
	<div class="cell">
		<div class="flex-box">
			<div class="w-100 left blue">
				<!-- 작성자가 없으면 탈퇴한 사용자로 대체하여 출력 -->
				<%if(boardDto.getBoardWriter() == null) { %>
               		<span class="gray">탈퇴한 사용자</span>
               	<%} else { %>
               		<a href="/home/views/member/detail.jsp?memberId=<%=boardDto.getBoardWriter()%>">
             			<%=boardDto.getBoardWriter()%>
             		</a>
               	<%} %>
			</div>
			<div class="w-100 right gray">
				<fmt:formatDate value="<%=boardDto.getBoardWtime()%>" 
								pattern="yyyy-MM-dd HH:mm:ss"/>
			</div>
		</div>
	</div>
	<hr>
	<div class="cell" style="min-height:200px;">
		<!-- pre 태그는 엔터나 띄어쓰기 등 기본 여백을 그대로 표시 -->
		<pre class="content-viewer"><%=boardDto.getBoardContent()%></pre>
	</div>
	<div class="cell mt-20">
		<!-- 댓글 수 -->
		<i class="fa-solid fa-comment-dots blue"></i> 	
		<span><%=boardDto.getBoardReply()%></span> 
		
		<!-- 조회 수 -->
		<i class="fa-solid fa-eye ms-40"></i> 			
		<span><%=boardDto.getBoardRead()%></span> 
		
		<!-- 좋아요 수 -->
		<i class="fa-solid fa-heart ms-40 red"></i>		
		<span><%=boardDto.getBoardLike()%></span> 
	</div>
	<hr>
	<div class="cell">
		
		<%if(isMember) { %>
		<a href="./write.jsp" class="form-btn positive">글쓰기</a>
		<a href="./write.jsp?boardParent=<%=boardDto.getBoardNo()%>" class="form-btn positive">답글쓰기</a>
		<%} %>
		
		<a href="./list.jsp" class="form-btn neutral">목록보기</a>
		
		<!-- 수정버튼은 작성자 본인인 경우에만 출력 -->
		<%if(isWriter){ %>
		<a href="./edit.jsp?boardNo=<%=boardDto.getBoardNo()%>" 
			class="form-btn negative">수정하기</a>
		<%} %>
		
		<!-- 삭제버튼은 본인 또는 관리자인 경우에만 출력 -->
		<%if(isWriter || isAdmin) { %>
		<a href="./delete.do?boardNo=<%=boardDto.getBoardNo()%>" 
			class="form-btn negative" onclick="return checkMove();">삭제하기</a>
		<%} %>
	</div>
</div>

<jsp:include page="/views/template/footer.jsp"></jsp:include>