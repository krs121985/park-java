package api.lang.etc;

import java.io.IOException;

public class Test03런타임클래스 {
	public static void main(String[] args) throws IOException {
		//Runtime 클래스
		//- 외부 실행 환경으로 명령을 전송하게 하는 도구 (ex : 운영체제)
		//- (주의) 생성자가 존재하지 않는 클래스
		//	1. 모든 필드 및 메소드가 static인 경우 : 빠르고 편하게 아무데서나 쓸 수 있도록 구현된 클래스
		//	2. static이 아닌 필드나 메소드가 있는 경우 : 생성 제한이 걸린 경우 (정해진 방식으로만 생성 및 대여)
		
		//2번에 해당되는 경우에는 반드시 "생성 명령"이 존재하므로 이를 찾아야 한다
		//- 클래스명 또는 instance라는 키워드를 찾으면 됨
		//- 이 클래스의 경우 getRuntime()이나 getInstance()중 하나가 일반적인 이름
		
		//Runtime rt = new Runtime();//안됨
		Runtime rt = Runtime.getRuntime();//생성 명령
		
		//외부 실행 환경 정보
		System.out.println(rt.availableProcessors());//CPU 코어 개수
		System.out.println(rt.freeMemory());//여유 메모리
		
		//외부에 실행 명령 전송
		//- 명령을 단어 단위로 만들어서 문자열 배열로 실행
		String os = System.getProperty("os.name").toLowerCase();
		if(os.startsWith("windows")) {//윈도우
			String[] command = new String[] {"cmd", "/c", "start", "https://www.naver.com"};//windows
			rt.exec(command);
		}
		else if(os.startsWith("mac")) {//맥
			String[] command = new String[] {"open", "https://www.naver.com"};//mac
			rt.exec(command);
		}
	}
}











