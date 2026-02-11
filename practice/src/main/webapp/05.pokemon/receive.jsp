<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 수신 및 등록 처리 -->
<%
	//파라미터 수신 코드
	String pokemonName = request.getParameter("pokemonName");
	String pokemonType = request.getParameter("pokemonType");
	
	//데이터베이스 연결 및 명령 전송 코드
	//- 자바에서는 사용할 데이터베이스 종류를 모르기 때문에 알려줘야 한다 (ojdbc11.jar)
	//- WEB-INF 안에 있는 lib 폴더에 넣으면 자동 등록된다.
	
	//드라이버 설치 코드(자바에게 오라클을 쓸 것이라고 정보를 제공하는 파일을 알려주기)
	Class.forName("oracle.jdbc.OracleDriver");
	
	//데이터베이스 연결을 위해 필요한 정보
	String url = "jdbc:oracle:thin:@localhost:1521:xe";//접속주소
	String username = "the01";//계정
	String password = "the01";//비밀번호
	
	//도구 생성 (접속도구, 구문실행도구)
	Connection conn = DriverManager.getConnection(url, username, password);//접속도구
	String sql = "insert into pokemon(pokemon_no, pokemon_name, pokemon_type) "
			+"values(pokemon_seq.nextval, ?, ?)";//두 개의 데이터를 구문과 합쳐서 보낼 예정이란 뜻! (미완성 구문)
	PreparedStatement ps = conn.prepareStatement(sql);//구문실행도구
	//미완성된 홀더 부분에 들어갈 데이터를 지정하는 코드를 작성
	ps.setString(1, pokemonName);//1번 물음표에 pokemonName을 문자열 형식으로 채우세요!
	ps.setString(2, pokemonType);//2번 물음표에 pokemonType을 문자열 형식으로 채우세요!
	ps.executeUpdate();//실행하세요!
	
	//최종 정리
	ps.close();
	conn.close();
%>

<h1>등록이 완료되었습니다</h1>
<h2><a href="./send.jsp">추가 등록하기</a></h2>





