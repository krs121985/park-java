<%@page import="home.util.CompareUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="home.beans.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.BoardDao"%>
<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@page import="home.beans.PageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="pageVO" class="home.beans.PageVO"></jsp:useBean>
<jsp:setProperty property="*" name="pageVO"/>

<%
	//게시판에서는 기간검색이 없다고 가정(있어도 됨)
	//PageVO pageVO = new PageVO();
	//BeanUtils.populate(pageVO, request.getParameterMap());
	
	BoardDao boardDao = new BoardDao();
	List<BoardDto> notices = boardDao.selectNoticeList();//공지사항
	List<BoardDto> boards = boardDao.selectList(pageVO);//현재 페이지의 게시글
	List<BoardDto> list = new ArrayList<>();//합쳐서 보여줄 새로운 도구
	list.addAll(notices);
	list.addAll(boards);
	int count = boardDao.count(pageVO); 
%>    

<jsp:include page="/views/template/header.jsp"></jsp:include>

<div class="container w-1000 mt-50 mb-50">
	<div class="cell center">
	    <h1>자유 게시판</h1>
	</div>
	<div class="cell center mb-40">자유로운 일상생활 이야기를 나눠보세요!</div>
	
	<!-- 회원에게만 글 작성 버튼을 출력 -->
	<%if(session.getAttribute("loginId") != null) { %>
	<div class="cell right">
		<a href="./write.jsp" class="form-btn positive">
			<i class="fa-solid fa-pen"></i>
			<span>신규 글 작성</span>
		</a>
	</div>
	<%} %>
	
	<div class="cell">
	    <!-- 테이블은 사용자의 편의를 위해 내용에 따라 폭을 조정을 하므로 이를 제거해야 말줄임표 처리가 가능 -->
	    <table class="grid hover" style="table-layout: fixed;">
	        <thead>
	            <tr>
	                <th width="8%">번호</th>
	                <th width="8%">주제</th>
	                <th width="35%">제목</th>
	                <th>작성자</th>
	                <th>작성일</th>
	                <th>그룹</th>
	                <th>상위</th>
	                <th>차수</th> 
	            </tr>
	        </thead>
	        <tbody class="center">
	        	<%-- 일반 게시글 --%>
	        	<%for(BoardDto boardDto : list) { %>
	        	
	        	<%if(CompareUtil.equals(boardDto.getBoardHead(), "공지")) { %>
	        	<tr style="background-color:#ffeaa788">
	        	<%} else { %>
	        	<tr>
	        	<%} %>
	                <td><%=boardDto.getBoardNo()%></td>
	                <td><%=boardDto.getBoardHead() == null ? "" : boardDto.getBoardHead()%></td>
	                <td class="left ellipsis" style="padding-left:<%=boardDto.getBoardDepth() * 20%>px">
	                	<!-- 답글일 경우만 아이콘 추가 -->
	                	<%if(boardDto.getBoardDepth() > 0) { %>
	                	<i class="fa-solid fa-reply fa-rotate-180"></i>
	                	<%} %>
	                
	                	<!-- 게시글 제목 --> 
	                	<a href="./detail.jsp?boardNo=<%=boardDto.getBoardNo()%>">
	                		<%=boardDto.getBoardTitle()%>
	                	</a>
	                	<!-- 댓글이 있으면 댓글 수 출력 -->
	                	<%if(boardDto.getBoardReply() > 0) { %>
                		<span class="ms-10 blue">
                			<i class="fa-solid fa-comment-dots"></i>
<%--                 			<span><%=boardDto.getBoardReply()%></span> --%>
							<span>
								<fmt:formatNumber value="<%=boardDto.getBoardReply()%>"
													pattern="#,###"></fmt:formatNumber>
							</span>
                		</span>
	                	<%} %>
	                	
	                	<!-- 좋아요가 있으면 좋아요 수 출력 -->
	                	<%if(boardDto.getBoardLike() > 0) { %>
	                	<span class="ms-10 red">
                			<i class="fa-solid fa-heart"></i>
<%--                 			<span><%=boardDto.getBoardLike()%></span> --%>
							<span>
								<fmt:formatNumber value="<%=boardDto.getBoardLike()%>"
													pattern="#,###"></fmt:formatNumber>
							</span>
                		</span>
	                	<%} %>
	                	
	                	<!-- 조회수 출력 -->
	                	<span class="ms-10">
                			<i class="fa-solid fa-eye"></i>
<%--                 			<span><%=boardDto.getBoardRead()%></span> --%>
							<span>
								<fmt:formatNumber value="<%=boardDto.getBoardRead()%>"
													pattern="#,###"></fmt:formatNumber>
							</span> 
                		</span>
	           	    </td>
	           	    
	                <td>
	           	    	<!-- 작성자 표시 영역 -->
	                	<%if(boardDto.getBoardWriter() == null) { %>
	                		<span class="gray">탈퇴한 사용자</span>
	                	<%} else { %>
	                		<span class="blue">
	                			<a href="/home/views/member/detail.jsp?memberId=<%=boardDto.getBoardWriter()%>">
	                				<%=boardDto.getBoardWriter()%>
	                			</a>
	                		</span>
	                	<%} %>
	                </td>
	                <td><%=boardDto.getBoardWtimeProcess()%></td> 
	                <td><%=boardDto.getBoardGroup()%></td> 
	                <td><%=boardDto.getBoardParent()%></td>
	                <td><%=boardDto.getBoardDepth()%></td>
	            </tr>
	            <%} %>
	        </tbody>
	    </table>
	</div>
	<div class="cell center mt-40">
    	<!-- 페이지 네비게이터(page navigator) 혹은 페이지네이션(pagination) -->
        <jsp:include page="/views/template/pagination.jsp">
        	<jsp:param name="count" value="<%=count%>"/>
        </jsp:include>
    </div>
    <div class="cell center mt-40">
        <form autocomplete="off">
            <select name="column" class="form-input">
                <option value="board_title" <%=pageVO.getColumnValue().equals("board_title") ? "selected":""%>>제목</option>
                <option value="board_head" <%=pageVO.getColumnValue().equals("board_head") ? "selected":""%>>말머리</option>
                <option value="board_writer" <%=pageVO.getColumnValue().equals("board_writer") ? "selected":""%>>작성자</option>
            </select>
            <input type="text" name="keyword" placeholder="검색어 입력" 
            	class="form-input" value="<%=pageVO.getKeywordValue()%>">
            <button type="submit" class="form-btn positive">검색</button>
        </form>
    </div>
</div>

<jsp:include page="/views/template/footer.jsp"></jsp:include>