<%@page import="home.beans.MemberDao"%>
<%@page import="home.beans.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	사용자가 보낸 로그인 정보(아이디, 비밀번호)를 받아서 판정 후 이동 처리
// 	String memberId = request.getParameter("memberId");
// 	String memberPw = request.getParameter("memberPw");
	
// 	MemberDto memberDto = new MemberDto();
// 	memberDto.setMemberId(request.getParameter("memberId"));
// 	memberDto.setMemberPw(request.getParameter("memberPw"));
%>

<jsp:useBean id="memberDto" class="home.beans.MemberDto"></jsp:useBean>
<jsp:setProperty property="memberId" name="memberDto"/>
<jsp:setProperty property="memberPw" name="memberDto"/>

<%
	MemberDao memberDao = new MemberDao();
	MemberDto findMemberDto = memberDao.selectOne(memberDto.getMemberId()); 
	//로그인이 되려면...?
	//1. 아이디가 존재해야 한다 (findMemberDto가 null이 아니면 된다)
	//2. 비밀번호가 같아야 한다
	boolean valid = findMemberDto != null && findMemberDto.getMemberPw().equals(memberDto.getMemberPw());
	
	if(valid) {//로그인 성공
		//(+추가) 이 회원이 만약 차단된 상태라면 로그인에 성공했더라도 로그인 처리를 하지 않고 차단 페이지로 강제 이동
		if(findMemberDto.getMemberBlock().equals("Y")) {//차단된 회원이라면
			response.sendRedirect("./block.jsp");//차단 페이지로 강제 리다이렉트
			return;
		}
	
		//(+추가) 회원의 최종로그인 시각을 갱신시키도록 처리
		//(ex) testuser001의 최종로그인시각을 갱신하려면 
		// → update member set member_login=sysdate where member_id='testuser001';
		//memberDao.updateMemberLogin(memberDto.getMemberId()); 
		memberDao.updateMemberLogin(findMemberDto.getMemberId()); 
		
		//로그인에 성공했다는 표시를 남기기 위해 세션에 데이터를 저장
		//- 세션에 데이터는 최소한으로 저장할 수 있어야 한다 (아이디, 등급)
		session.setAttribute("loginId", findMemberDto.getMemberId());
		session.setAttribute("loginLevel", findMemberDto.getMemberLevel());
		
		response.sendRedirect("/home");//상대경로로 쓰면 `../../index.jsp` 라서 매우 불편
	}
	else {//로그인 실패
		response.sendRedirect("./login.jsp?error");
	}
%>










