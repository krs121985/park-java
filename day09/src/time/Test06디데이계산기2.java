package time;

import java.time.LocalDate;

public class Test06디데이계산기2 {
	public static void main(String[] args) {
		
		//어떤 날짜를 하나 생성
		LocalDate target = LocalDate.parse("2026-01-09");
		
		for(int day=100; day<=1000; day+=100) {
			LocalDate future = target.plusDays(day);
			System.out.println(day+"일 뒤 : " + future);
		}
		
	}
}
