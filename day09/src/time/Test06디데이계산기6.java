package time;

import java.time.LocalDate;
import java.util.Scanner;

public class Test06디데이계산기6 {
	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("기준 날짜 입력 : ");
			String input = sc.next();
			
			LocalDate target = LocalDate.parse(input);
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
		catch(Exception e) {
			System.err.println("프로그램 실행 중 오류가 발생했습니다.\n다시 실행해주시기 바랍니다!");
		}
		
	}
}
