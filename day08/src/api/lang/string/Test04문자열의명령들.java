package api.lang.string;

public class Test04문자열의명령들 {
	public static void main(String[] args) {
		//비교 명령들
		//- 같은지 판정하는 메소드 : equals(), equalsIgnoreCase()
		//- 비슷한지 판정하는 메소드 : startsWith(), endsWith(), contains(), indexOf()
		
		String a = "https://www.naver.com";
		
		//(Q) a는 홈페이지 주소인가요?
		System.out.println("홈페이지 주소인가요?");
		System.out.println(a.startsWith("http://") || a.startsWith("https://"));
		
		//(Q) a는 기업 홈페이지인가요?
		System.out.println("기업 홈페이지 주소인가요?");
		System.out.println(a.endsWith(".com"));
		
		//(Q) a는 네이버 관련 홈페이지인가요?
		System.out.println("네이버 관련 주소인가요?");
		System.out.println(a.contains("naver"));
		System.out.println(a.indexOf("naver"));//좌측 첫 번째 시작지점 (없으면 -1)
		
		
		//편집 명령
		//- 문자열은 불변이기 때문에 편집하면 새로 복사된 신규 문자열이 생성된다 (원본은 변하지 않음)
		String b = "Hello";
		System.out.println(b.toLowerCase());//소문자 변환
		System.out.println(b.toUpperCase());//대문자 변환
		
		String c = "이런 개나리 같은 색상을 보았나";
		//System.out.println(c.replace("개나리", "***"));//치환
		
		String filter = "개나리";
		String star = "*";
		System.out.println(c.replace(filter, star.repeat(filter.length())));//치환
		
		//변환 명령 (↔ 원시형)
		
		//int → String
		int d = 100;
		//String e = d;
		String e = String.valueOf(d);
		System.out.println("e = " + e);
		
		//String → int
		String f = "1234";
		//int g = f;
		int g = Integer.parseInt(f);//int를 도와주는 클래스 Integer의 명령으로 문자열을 int로 변환할 수 있다!
		
		//원시형을 도와주는 클래스들 (Wrapper class)
		//boolean을 도와주는 Boolean 클래스 ... Boolean.parseBoolean(문자열)
		//long을 도와주는 Long 클래스 ......... Long.parseLong(문자열)
		//float를 도와주는 Float 클래스 ....... Float.parseFloat(문자열)
		//double을 도와주는 Double 클래스 ..... Double.parseDouble(문자열)
	}
}


















