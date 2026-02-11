<%@page import="java.util.List"%>
<%@page import="home.beans.HistoryDao"%>
<%@page import="home.beans.HistoryDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="pageVO" class="home.beans.PageVO"></jsp:useBean>
<jsp:setProperty property="*" name="pageVO"></jsp:setProperty>

<%
	HistoryDao historyDao = new HistoryDao();
	List<HistoryDto> historyList = historyDao.selectListByPaging(pageVO);
	
	//정확한 페이징을 원한다면(상한선 설정을 원할 경우) 현재 상태에 맞는 카운트를 구해야 한다
	//→ historyList.size()는 데이터 개수가 아니다
	int count = historyDao.count(pageVO);
%>

<jsp:include page="/views/template/header.jsp"></jsp:include>

<div class="container w-800 mt-50">
	<div class="cell">
		<h2>회원 로그인 기록 조회</h2>
	</div>
	
	<hr>
	
	<!-- 검색창 -->
	<div class="cell">
		<form method="get">
			<div class="flex-box">
				<select name="column" class="form-input">
					<option value="history_member" <%=pageVO.getColumnValue().equals("history_member") ? "selected":""%>>아이디</option>
					<option value="history_origin" <%=pageVO.getColumnValue().equals("history_origin") ? "selected":""%>>접속주소</option>
				</select>
				<input type="text" name="keyword" class="form-input ms-10"
										value="<%=pageVO.getKeywordValue()%>">
				<button type="submit" class="form-btn ms-10">
					<i class="fa-solid fa-magnifying-glass"></i>
					<span>검색</span>
				</button>
			</div>
			<div class="flex-box mt-10">
				<input type="date" name="begin" class="form-input" size="8" placeholder="시작일"
						value="<%=pageVO.getBeginValue()%>">
				<h3 class="ms-10 me-10">~</h3>
				<input type="date" name="end" class="form-input" size="8" placeholder="종료일"
						value="<%=pageVO.getEndValue()%>">
			</div>
			<div class="mt-10">
				<select name="pagesize" class="form-input">
					<option value="10" <%=pageVO.getPagesizeNumber()==10 ? "selected":""%>>10개씩 보기</option>
					<option value="15" <%=pageVO.getPagesizeNumber()==15 ? "selected":""%>>15개씩 보기</option>
					<option value="20" <%=pageVO.getPagesizeNumber()==20 ? "selected":""%>>20개씩 보기</option>
					<option value="30" <%=pageVO.getPagesizeNumber()==30 ? "selected":""%>>30개씩 보기</option>
					<option value="50" <%=pageVO.getPagesizeNumber()==50 ? "selected":""%>>50개씩 보기</option>
					<option value="100" <%=pageVO.getPagesizeNumber()==100 ? "selected":""%>>100개씩 보기</option>
				</select>
			</div>
		</form>
	</div>
	
	<!-- 결과표시영역 -->
	<div class="cell">
		<table class="grid stripe">
			<thead>
				<tr>
					<th>일시</th>
					<th>아이디</th>
					<th>접속주소</th>
				</tr>
			</thead>
			<tbody class="center">
				<%if(historyList.isEmpty()) { %>
					<tr>
						<td colspan="3">데이터가 존재하지 않습니다</td>
					</tr>
				<%} else { %>
					<%for(HistoryDto historyDto : historyList) { %>
					<tr>
						<td>
							<fmt:formatDate value="<%=historyDto.getHistoryTime()%>"
											pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td><%=historyDto.getHistoryMember()%></td>
						<td><%=historyDto.getHistoryOrigin()%></td>
					</tr>
					<%} %>
				<%} %>
			</tbody>
		</table>
	</div>
	
	<!-- 페이지 네비게이터(pagination) -->
	<div class="cell mt-40 mb-40">
		<jsp:include page="/views/template/pagination.jsp">
			<jsp:param name="count" value="<%=count%>"/>
		</jsp:include>
	</div>
	
	<!-- 확인용 테스트 영역 -->
	<div class="cell">
		<%=pageVO%>
	</div>
	
</div>

<jsp:include page="/views/template/footer.jsp"></jsp:include>





