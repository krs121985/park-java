package time;

import java.time.LocalDate;

public class Test06디데이계산기 {
	public static void main(String[] args) {
		
		//어떤 날짜를 하나 생성
		LocalDate target = LocalDate.parse("2026-01-09");
		
		//100일 뒤를 출력
		LocalDate future = target.plusDays(100);
		System.out.println("100일 뒤 : " + future);
		
	}
}
