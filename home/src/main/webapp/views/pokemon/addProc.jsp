<%@page import="home.beans.PokemonDao"%>
<%@page import="home.beans.PokemonDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//사용자에게 보여주지 않는 페이지 (화면 코드가 필요없음)
	//String pokemonName = request.getParameter("pokemonName");
	//String pokemonType = request.getParameter("pokemonType");
	
	PokemonDto pokemonDto = new PokemonDto();
	pokemonDto.setPokemonName(request.getParameter("pokemonName"));
	pokemonDto.setPokemonType(request.getParameter("pokemonType"));
	
	PokemonDao pokemonDao = new PokemonDao();
	pokemonDao.insert(pokemonDto);
	
	response.sendRedirect("./addResult.jsp");
%>



