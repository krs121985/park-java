package time;

import java.time.LocalDate;

public class Test06디데이계산기4 {
	public static void main(String[] args) {
		
		//어떤 날짜를 하나 생성
		LocalDate target = LocalDate.parse("2026-01-09");
		int limit = 5;
		
		for(int day=1; day <= limit * 365; day++) {
			if(day % 100 == 0 || day % 365 == 0) {
				LocalDate future = target.plusDays(day);
				if(day % 365 == 0) {
					System.out.println(day/365+"주년 : " + future);
				}
				else {
					System.out.println("D+"+day+" : " + future);
				}
			}
		}
		
	}
}
