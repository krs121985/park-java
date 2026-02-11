<%@page import="home.beans.PokemonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//삭제 페이지
	int pokemonNo = Integer.parseInt(request.getParameter("pokemonNo"));//전달된 번호를 받는다
	PokemonDao pokemonDao = new PokemonDao();//포켓몬 테이블 이용을 위해 전용 도구를 생성한다
	boolean result = pokemonDao.delete(pokemonNo);//삭제를 지시하고 결과를 받는다
	response.sendRedirect("./list.jsp");//목록으로 강제 이동시킨다
%>