<%@page import="home.util.CookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//mainPop이라는 이름의 쿠키가 있다면 나오지 않도록 처리 (값은 중요하지 않음)
	String mainPop = CookieUtil.getValue(request, "mainPop");
%>

<%if(mainPop == null) { %>

<!-- 
	화면 중앙에 표시되는 광고성 팝업 화면
	.backdrop - 화면 배경을 뒤덮는 div (클릭 방지용) 
-->
<style>
	.backdrop {
		position:fixed;
		top:0;
		left:0;
		right:0;
		bottom:0;
		z-index:999;
		
		/* 배경색에 alpha를 부여하여 뒤가 비치게 처리 (0 : 완전투명 , 1 : 완전불투명) */
		background-color: rgba(0, 0, 0, 0.3);
		
		/* 정가운데 위치하도록 처리 */
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.link {
		text-decoration: none;
		color: #2d3436;
	}
	.link:hover {
		color: #0984e3;
	}
</style>

<script type="text/javascript">
	function closePopup() {
		//.backdrop을 찾아서 제거
		var backdrop = document.querySelector(".backdrop");
		backdrop.remove();//삭제
		return false;//a태그가 작동하지 않도록 false를 반환
	}
</script>

<div class="backdrop">
	<div class="container w-400" style="background: white; padding:10px;">
		<div class="cell center">
			<h2>대박 행사 안내</h2>
		</div>
		<div class="cell center">
			<img src="https://picsum.photos/400/400" width="100%">
		</div>
		<div class="cell">
			<div class="flex-box">
				<div class="w-100 left">
					<a href="/home/views/noAdToday.do" class="link">오늘 하루 안보기</a>
				</div>
				<div class="w-100 right">
					<a href="#" class="link" onclick="return closePopup();">닫기</a>
				</div>
			</div>
		</div>
	</div>
</div>

<%} %>

