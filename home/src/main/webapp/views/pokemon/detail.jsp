<%@page import="home.beans.PokemonDto"%>
<%@page import="home.beans.PokemonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//최상단에서 페이지에 필요한 정보를 조회
	int pokemonNo =  Integer.parseInt(request.getParameter("pokemonNo"));
	PokemonDao pokemonDao = new PokemonDao();
	PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
%>

<jsp:include page="/views/template/header.jsp"></jsp:include>

<script type="text/javascript">
	function deleteConfirm() {
		var choice = window.confirm("정말 삭제하시겠습니까?");
		return choice;
	}
</script>


<div class="container w-600">
	
	<div class="cell center">
		<h2>몬스터 정보</h2>
	</div>
	
	<div class="cell">
		<img src="./image.do?pokemonNo=<%=pokemonDto.getPokemonNo()%>" width="150">
	</div>
	
	<div class="cell flex-box mt-40"> 
		<div class="w-25 blue">몬스터 번호</div>
		<div class="w-75"><%=pokemonDto.getPokemonNo()%></div>
	</div>
	<div class="cell flex-box mt-40">
		<div class="w-25 blue">몬스터 이름</div>
		<div class="w-75"><%=pokemonDto.getPokemonName()%></div>
	</div>
	<div class="cell flex-box mt-40">
		<div class="w-25 blue">몬스터 속성</div>
		<div class="w-75"><%=pokemonDto.getPokemonType()%></div>
	</div>
	
	<!-- 각종 버튼들 -->
	<hr class="mt-40">
	<div class="cell">
		<a href="./add.jsp" class="form-btn positive">
			<i class="fa-solid fa-plus"></i>
			<span>신규 등록</span>
		</a> 
		<a href="./list.jsp" class="form-btn neutral">
			<i class="fa-solid fa-list"></i>
			<span>목록 보기</span>
		</a>
		<a href="./edit.jsp?pokemonNo=<%=pokemonNo%>" class="form-btn negative">
			<i class="fa-solid fa-pen"></i>
			<span>정보 수정</span>
		</a>
		<a href="./delete.do?pokemonNo=<%=pokemonNo%>" class="form-btn negative"
									onclick="return deleteConfirm();">
			<i class="fa-solid fa-trash"></i>
			<span>정보 삭제</span>
		</a>
	</div>
	
</div>


<jsp:include page="/views/template/footer.jsp"></jsp:include>


