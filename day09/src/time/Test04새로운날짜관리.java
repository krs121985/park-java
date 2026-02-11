package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Test04새로운날짜관리 {
	public static void main(String[] args) {
		//자바 8 버전부터 등장한 java.time 패키지
		//- Date, Calendar의 불편사항 모두 개선
		
		//기존의 문제점들
		//1. 월을 0~11로 관리했다 → 1~12로 변경
		//2. 세터 게터가 너무 옛날 방식이다 → 현대적으로 변경 (항목별로)
		//3. 윤년 파악이 되긴 하지만 불편하다 → 확인할 수 있는 메소드 제공
		//4. (중요) 날짜가 가변 데이터이다 → 불변으로 변경 (현대 프로그래밍의 트렌드)
		//5. 시간 변경은 되지만 서로 다른 두 시간의 차이 구하기가 어려움
		//6. (중요) Date나 Calendar는 반드시 날짜와 시간이 같이 설정되야 한다 → 용도별로 클래스 세분화
		//7. Date클래스가 똑같은 이름이 있어서 import 하기가 불편하다~
		
		
		LocalDate a = LocalDate.now();//오늘(날짜만)
		System.out.println("a = " + a);
		
		LocalTime b = LocalTime.now();//지금(시간만)
		System.out.println("b = " + b);
		
		LocalDateTime c = LocalDateTime.now();//현재(날짜+시간)
		System.out.println("c = " + c);
		
	}
}








