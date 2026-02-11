package time;

import java.time.LocalDate;
import java.util.Scanner;

public class Test06디데이계산기5 {
	public static void main(String[] args) {
		
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
}
