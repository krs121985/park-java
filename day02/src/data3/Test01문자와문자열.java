package data3;

public class Test01문자와문자열 {
	public static void main(String[] args) {
		//문자
		//- 글자 한 개를 저장하기 위한 형태 (char)
		//- 외따옴표를 사용
		//- 정수 형태로 취급됨
		//- 아스키코드 → 확장아스키코드 → 유니코드
		//- 자바는 유니코드가 나오고 나서 출시된 언어이므로 유니코드를 기본적으로 사용할 수 있음
		char a = '힣';
		System.out.println("a = " + a);
		System.out.println("a = " + (int)a);
		
		//문자열
		//- 문자를 여러 개 모아놓은 형태
		//- String이라는 형태와 쌍따옴표를 사용하여 글자를 저장
		//- 숫자가 아님
		//- 처음으로 나온 "참조형(Reference type)" 데이터
		//- 리모컨과 본체로 구성된 주문제작방식의 데이터 (느려도 딱맞게 쓰고싶을 때)
		//- int, boolean, float, double 등의 원시형과 다르게 메소드(버튼)이 제공됨
		String b = "hello";
		System.out.println("b = " + b);
		System.out.println(b.length());//글자수 체크 버튼
		
		//- 특수문자를 사용할 수 있다 (escape sequence라 부름)
		//- \t : 탭키를 의미 , \n : 엔터(줄바꿈)를 의미
		String c = "피자	떡볶이	라면";
		System.out.println("c = " + c);
		String d = "피자\t떡볶이\t라면";
		System.out.println("d = " + d);
		String e = "피자\n떡볶이\n라면";
		System.out.println(e);
		
		//나는 오늘 "치킨"이 먹고 싶어요  <---- 출력
		String f = "나는 오늘 \"치킨\"이 먹고 싶어요";
		System.out.println("f = " + f);
	}
}




