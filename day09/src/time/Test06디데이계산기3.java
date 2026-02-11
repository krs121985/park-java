package time;

import java.time.LocalDate;

public class Test06디데이계산기3 {
	public static void main(String[] args) {
		
		//어떤 날짜를 하나 생성
		LocalDate target = LocalDate.parse("2026-01-09");
		
		for(int day=1; day<=1000; day++) {
			if(day % 100 == 0 || day % 365 == 0) {
				LocalDate future = target.plusDays(day);
				System.out.println(day+"일 뒤 : " + future);
			}
		}
		
	}
}
