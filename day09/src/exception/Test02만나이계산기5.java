package exception;

import java.time.LocalDate;
import java.util.Scanner;

public class Test02만나이계산기5 {
	public static void main(String[] args) {
		
		try {
			//최초는 Plan A만 구현
			Scanner sc = new Scanner(System.in);
			System.out.print("생년월일 입력(YYYY-MM-DD) : ");
			String input = sc.next(); 
			
			int year = Integer.parseInt(input.substring(0, 4));
			int month = Integer.parseInt(input.substring(5, 7));
			
			//윤년 판정 및 형식 검사
			boolean leap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
			String regex;
			if(leap) {
				regex = "^(19[0-9]{2}|20[0-9]{2})-(02-(0[1-9]|1[0-9]|2[0-9])|(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))$";
			}
			else {
				regex = "^(19[0-9]{2}|20[0-9]{2})-(02-(0[1-9]|1[0-9]|2[0-8])|(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))$";
			}
			if(input.matches(regex) == false) {//형식에 맞지 않으면
				throw new Exception("올바른 날짜 형식이 아닙니다");
			}
			
			int currentYear = LocalDate.now().getYear();//현재 년도
			int currentMonth = LocalDate.now().getMonthValue();//현재 월
			
			int user = year * 12 + month;//입력값의 월 환산값
			int current = currentYear * 12 + currentMonth;//현재시각의 월 환산값
			
			//미래의 값인지 판정해서 강제 예외 처리
			//if(year > currentYear || (year == currentYear && month > currentMonth)) {//비추천(연/월 따로 생각)
			if(user > current) {//추천(환산된 값으로 생각)
				throw new Exception("미래의 날짜는 지정하실 수 없습니다");
			}
			
			int minus = current - user;//환산값 차이
			//System.out.println("minus = " + minus);
			
			int koreanAge = currentYear - year + 1;//한국나이
			int globalAge = minus / 12;//만나이
			
			System.out.println("당신의 한국나이 : " + koreanAge);
			System.out.println("당신의 만 나이 : " + globalAge + "("+minus/12+"년 "+minus%12+"개월)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}







