<%@page import="java.util.List"%>
<%@page import="home.beans.HistoryDao"%>
<%@page import="home.beans.HistoryDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	//검색과 관련된 데이터들을 받아서 HistoryDao를 통해 기록을 조회
	String column = request.getParameter("column");
	String keyword = request.getParameter("keyword");
	String begin = request.getParameter("begin");
	String end = request.getParameter("end");
// 	int page = 페이지번호;
// 	int size = 한페이지에표시할개수;
	
	HistoryDao historyDao = new HistoryDao();
	List<HistoryDto> historyList = historyDao.selectList(column, keyword, begin, end);
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
					<option value="history_member" <%=column!=null&&column.equals("history_member") ? "selected":""%>>아이디</option>
					<option value="history_origin" <%=column!=null&&column.equals("history_origin") ? "selected":""%>>접속주소</option>
				</select>
				<input type="text" name="keyword" class="form-input ms-10"
							value="<%=keyword==null ? "" : keyword%>">
				<button type="submit" class="form-btn ms-10">
					<i class="fa-solid fa-magnifying-glass"></i>
					<span>검색</span>
				</button>
			</div>
			<div class="flex-box mt-10">
				<input type="date" name="begin" class="form-input" size="8" placeholder="시작일"
						value="<%=begin==null ? "" : begin%>">
				<h3 class="ms-10 me-10">~</h3>
				<input type="date" name="end" class="form-input" size="8" placeholder="종료일"
						value="<%=end==null?"" : end%>">
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
	
</div>

<jsp:include page="/views/template/footer.jsp"></jsp:include>





