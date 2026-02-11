<%@page import="java.text.DecimalFormat"%>
<%@page import="home.beans.BookDto"%>
<%@page import="home.beans.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int bookNo = Integer.parseInt(request.getParameter("bookNo"));

	BookDao bookDao = new BookDao();
	BookDto bookDto = bookDao.selectOne(bookNo);
	
	DecimalFormat df = new DecimalFormat("#,###");
%>

<jsp:include page="/views/template/header.jsp"></jsp:include>

<script type="text/javascript">
	function deleteConfirm() {
		var choice = window.confirm("정말 삭제하시겠습니까?");
		return choice;
	}
</script>

<div class="container w-600">
	<div class="cell">
		<h2>『<%=bookDto.getBookTitle()%>』 도서 상세정보</h2>
	</div>
	
	<div class="cell">
		<img src="./cover.do?bookNo=<%=bookDto.getBookNo()%>" width="150">
	</div>
	
	<div class="cell mt-40">
		<div class="flex-box">
			<div class="w-25">도서번호</div>
			<div class="w-75"><%=bookDto.getBookNo()%></div>
		</div>
	</div>
	<div class="cell mt-40">
		<div class="flex-box">
			<div class="w-25">도서명</div>
			<div class="w-75"><%=bookDto.getBookTitle()%></div>
		</div>
	</div>
	<div class="cell mt-40">
		<div class="flex-box">
			<div class="w-25">장르</div>
			<div class="w-75"><%=bookDto.getBookGenre()%></div>
		</div>
	</div>
	<div class="cell mt-40">
		<div class="flex-box">
			<div class="w-25">페이지수</div>
			<div class="w-75"><%=bookDto.getBookPagecount()%>p</div>
		</div>
	</div>
	<div class="cell mt-40">
		<div class="flex-box">
			<div class="w-25">판매가</div>
			<div class="w-75"><%=df.format(bookDto.getBookPrice())%></div>
		</div>
	</div>
	<div class="cell mt-40">
		<div class="flex-box">
			<div class="w-25">대여상태</div>
			<div class="w-75">
				<%if(bookDto.getBookStatus().equals("대여가능")) { %>
				<span class="blue">대여가능</span>
				<%} else if(bookDto.getBookStatus().equals("대여중")) { %>
				<span class="gray">대여중</span>
				<%} else {%>
				<span class="red">대여불가</span>
				<%} %>
			</div>
		</div>
	</div>
	
	<div class="cell mt-40">
		<a href="./add.jsp" class="form-btn positive">
			<i class="fa-solid fa-plus"></i>
			<span>신규 등록</span>
		</a>
		<a href="./list.jsp" class="form-btn neutral">
			<i class="fa-solid fa-list"></i>
			<span>목록 보기</span>
		</a>
		<a href="./edit.jsp?bookNo=<%=bookNo%>" class="form-btn negative">
			<i class="fa-solid fa-pen"></i>
			<span>정보 변경</span>
		</a>
		<a href="./delete.do?bookNo=<%=bookNo%>" class="form-btn negative"
					onclick="return deleteConfirm();">
			<i class="fa-solid fa-trash"></i>
			<span>정보 삭제</span>
		</a>
	</div>
	
</div>

<jsp:include page="/views/template/footer.jsp"></jsp:include>

    