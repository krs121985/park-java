package exception;

import java.util.Scanner;

public class Test02만나이계산기2 {
	public static void main(String[] args) {
		
		//최초는 Plan A만 구현
		Scanner sc = new Scanner(System.in);
		System.out.print("생년월일 입력(YYYY-MM-DD) : ");
		String input = sc.next(); 
		
		int year = Integer.parseInt(input.substring(0, 4));
		int month = Integer.parseInt(input.substring(5, 7));
		
		int currentYear = 2026;//현재 년도
		int currentMonth = 1;//현재 월
		
		int user = year * 12 + month;//입력값의 월 환산값
		int current = currentYear * 12 + currentMonth;//현재시각의 월 환산값
		
		int minus = current - user;//환산값 차이
		//System.out.println("minus = " + minus);
		
		int koreanAge = currentYear - year + 1;//한국나이
		int globalAge = minus / 12;//만나이
		
		System.out.println("당신의 한국나이 : " + koreanAge);
		System.out.println("당신의 만 나이 : " + globalAge + "("+minus/12+"년 "+minus%12+"개월)");
		
	}
}







