<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 
	파일이란? 
	- 정해진 규격(약속)에 의해 정의된 글자들을 가지고 있는 하나의 도구(단위)
	- 형식에 따라 보관하는 글자가 다르며, 이를 해석하는 전용 프로그램들이 존재
	- 중요한건 글자가 들어있다는 점이며 이 글자를 서버로 보내는 행위를 "파일 업로드"라고 한다
	- 반대로 서버에 있는 파일의 글자를 가져오는 행위를 "파일 다운로드"라고 한다
	
	지금 보고 싶은건 업로드(upload)!
	
	업로드 시 주의사항은 다음과 같다
	1. 일반적인 전송형식으로는 파일이 전송되지 않는다
		- GET방식은 절대로 파일을 전송할 수 없다
		- POST라고 무조건 파일을 보낼 수 있는 것도 아니다
		- form에 enctype="multipart/form-data" 설정을 해야 파일 전송이 이루어진다 (수신측도 준비 필요)
	2. 파일은 DB에 들어갈 수 없다(있어도 없다)
-->

<h1>파일 업로드 예제</h1>

<form action="./upload.do" method="post" enctype="multipart/form-data">
	업로더 <input type="text" name="uploader"> <br><br>
	파일 <input type="file" name="attach" accept=".png, .jpg"> <br><br>
	<button type="submit">전송</button>
</form>




