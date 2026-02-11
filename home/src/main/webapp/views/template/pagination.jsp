<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//링크를 눌렀을 때 이동해야 할 페이지가 어딘지 알 수 없다 (이 페이지는 템플릿 페이지이기 때문)
	//→ 현재 위치한 페이지의 주소를 알아낼 필요가 있다
	String uri = request.getRequestURI();
%>

<!-- 각종 페이지의 상태를 알기 위해 PageVO를 여기서도 수신 -->
<jsp:useBean id="pageVO" class="home.beans.PageVO"></jsp:useBean>
<jsp:setProperty property="*" name="pageVO"/>

<!-- 목록 하단에 표시될 페이징 이동 도구를 템플릿으로 구현 -->
<div class="pagination">
	
	<!-- 이전 : (현재 구간의 시작블록 번호-1)로 이동 -->
	<%if(pageVO.isFirstBlock()) { %> 
	<a><i class="fa-solid fa-chevron-left"></i></a>
	<%} else { %>
	<a href="<%=uri%>?<%=pageVO.getQueryString()%>&page=<%=pageVO.getStartBlock()-1%>">
		<i class="fa-solid fa-chevron-left"></i>
	</a>
	<%} %>
	
	<!-- 숫자 -->
	<%for(int i=pageVO.getStartBlock(); i<=pageVO.getFinishBlock(); i++){ %>
		<a href="<%=uri%>?<%=pageVO.getQueryString()%>&page=<%=i%>"
			class="<%=i == pageVO.getPageNumber() ? "on" : ""%>"><%=i%></a>	
	<%} %>
	
	<!-- 다음 : (현재 구간의 마지막블록 번호+1)로 이동 -->
	<%if(pageVO.isLastBlock()){ %>
	<a><i class="fa-solid fa-chevron-right"></i></a>
	<%} else { %>
	<a href="<%=uri%>?<%=pageVO.getQueryString()%>&page=<%=pageVO.getFinishBlock()+1%>">
		<i class="fa-solid fa-chevron-right"></i>
	</a>
	<%} %>
</div>











