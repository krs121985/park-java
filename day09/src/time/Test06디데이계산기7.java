package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test06디데이계산기7 {
	public static void main(String[] args) {
		
		LocalDate target = LocalDate.parse("2026-01-09");
		System.out.println(target);//기본 형식(yyyy-MM-dd)
		
		//java.time 패키지에서는 기존처럼 SimpleDateFormat이 아니라 별도로 DateTimeFormatter를 사용
		
		//SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일 E");
		//System.out.println(fmt.format(date));
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("y년 M월 d일 E");
		System.out.println(target.format(fmt));		
		
	}
}
