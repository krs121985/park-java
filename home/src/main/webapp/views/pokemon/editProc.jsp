<%@page import="home.beans.PokemonDao"%>
<%@page import="home.beans.PokemonDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자에게 표시되지 않는 수정 처리 페이지
	PokemonDto pokemonDto = new PokemonDto();//전달되는 데이터를 모아주기 위한 객체를 생성
	pokemonDto.setPokemonNo(Integer.parseInt(request.getParameter("pokemonNo")));//번호 수신
	pokemonDto.setPokemonName(request.getParameter("pokemonName"));//이름 수신
	pokemonDto.setPokemonType(request.getParameter("pokemonType"));//속성 수신
	
	PokemonDao pokemonDao = new PokemonDao();//pokemon 테이블 전담 처리 도구 생성
	boolean result = pokemonDao.update(pokemonDto);//정보를 전달하며 수정하도록 지시하고 결과를 수신
	
	response.sendRedirect("./detail.jsp?pokemonNo="+pokemonDto.getPokemonNo());
%>