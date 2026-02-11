package condition;

import java.util.Scanner;

public class Test07날짜계산기4 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("연도를 입력하세요");
		int year = sc.nextInt();
		System.out.println("월을 입력하세요");
		int month = sc.nextInt();
		
		//처리
		//int count = 31 or 30 or 29 or 28;
		int count;
		if(month == 2) {	
			//count = 28 or 29;
			//처리
			boolean leap = year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
			if(leap) {
				count = 29;
			}
			else {
				count = 28;
			}
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11) {
			count = 30;
		}
		else {
			count = 31;
		}
		
		//출력
		System.out.println(year+"년 "+month+"월은 "+count+"일까지 있습니다");
		
	}
}
