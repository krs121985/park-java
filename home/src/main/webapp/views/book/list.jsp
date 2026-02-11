<%@page import="home.beans.BookDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String column = request.getParameter("column");
	String keyword = request.getParameter("keyword");
	
	BookDao bookDao = new BookDao();
	List<BookDto> list = bookDao.selectList(column, keyword);
%>

    
<jsp:include page="/views/template/header.jsp"></jsp:include>


<div class="container">
	
	<div class="cell">
		<h2>도서 목록</h2>
		<p>사이트에 등록된 모든 도서 정보를 확인해보세요!</p>
	</div>
	<hr>
	
	<!-- 검색창 -->
	<div class="cell">
		<form method="get">
			<div class="flex-box" style="justify-content: center;">
				<select name="column" class="form-input me-10">
					<option value="book_title" <%=column!=null&&column.equals("book_title") ? "selected":""%>>도서명</option>
					<option value="book_genre" <%=column!=null&&column.equals("book_genre") ? "selected":""%>>장르</option>
					<option value="book_status" <%=column!=null&&column.equals("book_status") ? "selected":""%>>대여상태</option>
				</select>
				<input type="text" name="keyword" class="form-input me-10" placeholder="검색"
							value="<%=keyword == null ? "" : keyword%>">
				<button type="submit" class="form-btn positive">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</div>
		</form>
	</div>
	
	<!-- 등록버튼 -->
	<div class="cell mt-40">
		<a href="./add.jsp" class="form-btn positive">
			<i class="fa-solid fa-plus"></i>
			<span>신규 도서 등록</span>
		</a>
	</div>
	
	<!-- 결과표시화면 -->
	<div class="cell">
		<table class="grid hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>장르</th>
					<th>도서명</th>
					<th>판매가</th>
				</tr>
			</thead>
			<tbody class="center">
				<%for(BookDto bookDto : list){ %>
				<tr>
					<td><%=bookDto.getBookNo()%></td>
					<td><%=bookDto.getBookGenre()%></td>
					<td class="left">
						<a href="./detail.jsp?bookNo=<%=bookDto.getBookNo()%>">
							<%=bookDto.getBookTitle()%>
						</a>
					</td> 
					<td><%=bookDto.getBookPrice()%></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	
	<!-- 페이지 네비게이터 -->
	<div class="cell mt-40">
		<div class="pagination">
			<a href="#" class="on">1</a>
			<a href="#">2</a>
			<a href="#">3</a>
			<a href="#">4</a>
			<a href="#">5</a>
			<a href="#">6</a>
			<a href="#">7</a>
			<a href="#">8</a>
			<a href="#">9</a>
			<a href="#">10</a>
		</div>
	</div>
	
</div>

<jsp:include page="/views/template/footer.jsp"></jsp:include>

