package data2;

import java.time.LocalDate; // 날짜 관련 도구 불러오기

public class Test02논리계산실습 {
	public static void main(String[] args) {
		//1. 2006년생이 "성인"인지 판정해서 출력
		// - 한국 나이는 태어난 해부터 올해까지의 숫자 개수 (a부터 b까지의 숫자 개수 , b - a + 1)
		
		//입력
		int birth = 2006;
		
		//처리
		//int year = 2025;
		
		// LocalDate.now()는 현재 날짜를, getYear()는 그 중 연도만 가져옵니다.
		int year = LocalDate.now().getYear();
		
		int age = year - birth + 1;
		System.out.println("age = " + age);
		
		boolean adult = age >= 20;
		
		//출력
		System.out.println("성인 = " + adult);
		
	}
}




